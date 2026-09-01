from typing import List
from collections import deque

class Solution:
    def minMoves(self, classroom: List[str], energy: int) -> int:
        m, n = len(classroom), len(classroom[0])

        # Give every litter cell a bit index.
        litter_id = {}
        start = None

        for r in range(m):
            for c in range(n):
                if classroom[r][c] == 'S':
                    start = (r, c)
                elif classroom[r][c] == 'L':
                    litter_id[(r, c)] = len(litter_id)

        total_litter = len(litter_id)
        full_mask = (1 << total_litter) - 1

        # best[r][c][mask] = maximum energy with which
        # we have reached (r, c) after collecting 'mask'.
        #
        # We don't need energy as a separate dimension because
        # reaching the same state with more energy is always better.
        best = [
            [[-1] * (1 << total_litter) for _ in range(n)]
            for _ in range(m)
        ]

        sr, sc = start
        best[sr][sc][0] = energy

        # (row, col, remaining_energy, mask, moves)
        q = deque([(sr, sc, energy, 0, 0)])

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        while q:
            r, c, cur_energy, mask, moves = q.popleft()

            if mask == full_mask:
                return moves

            # No energy means we cannot make another move.
            if cur_energy == 0:
                continue

            for dr, dc in directions:
                nr, nc = r + dr, c + dc

                if not (0 <= nr < m and 0 <= nc < n):
                    continue

                if classroom[nr][nc] == 'X':
                    continue

                # Moving costs 1 energy.
                next_energy = cur_energy - 1

                # R resets energy after entering the cell.
                if classroom[nr][nc] == 'R':
                    next_energy = energy

                # Collect litter.
                next_mask = mask

                if (nr, nc) in litter_id:
                    bit = litter_id[(nr, nc)]
                    next_mask |= 1 << bit

                # If we have already reached this position with the
                # same collected litter and MORE energy, this state
                # cannot give us anything better.
                if next_energy <= best[nr][nc][next_mask]:
                    continue

                best[nr][nc][next_mask] = next_energy

                q.append((
                    nr,
                    nc,
                    next_energy,
                    next_mask,
                    moves + 1
                ))

        return -1
