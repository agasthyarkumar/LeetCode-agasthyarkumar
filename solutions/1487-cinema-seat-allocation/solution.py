from collections import defaultdict

class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: list[list[int]]) -> int:
        rows = defaultdict(int)

        # Store reserved seats (only seats 2-9 matter)
        for r, s in reservedSeats:
            if 2 <= s <= 9:
                rows[r] |= 1 << (s - 2)

        # Rows without reservations can fit 2 groups
        ans = (n - len(rows)) * 2

        # Bit masks for the three possible seat blocks
        left = int("00001111", 2)    # seats 2-5
        middle = int("00111100", 2)  # seats 4-7
        right = int("11110000", 2)   # seats 6-9

        for mask in rows.values():
            left_ok = (mask & left) == 0
            middle_ok = (mask & middle) == 0
            right_ok = (mask & right) == 0

            if left_ok and right_ok:
                ans += 2
            elif left_ok or middle_ok or right_ok:
                ans += 1

        return ans
