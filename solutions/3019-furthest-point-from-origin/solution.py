from typing import Final

class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        allowed: Final = {'L', 'R', '_'}
        if any(ch not in allowed for ch in moves):
            raise ValueError("moves may contain only 'L', 'R', or '_'")
        left_cnt = moves.count('L')
        right_cnt = moves.count('R')
        wild_cnt = moves.count('_')
        net_bias = right_cnt - left_cnt
        return abs(net_bias) + wild_cnt

