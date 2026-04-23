class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        Find median of two sorted arrays in O(log(m+n)) time.

        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # Ensure nums1 is the smaller array to minimize binary search range
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m, n = len(nums1), len(nums2)
        total_len = m + n
        half = (total_len + 1) // 2  # +1 handles both odd/even uniformly

        lo, hi = 0, m
        while lo <= hi:
            i = (lo + hi) // 2          # partition of nums1
            j = half - i                # partition of nums2

            # Edge values for comparison; use infinities when out of bounds
            left1 = nums1[i - 1] if i > 0 else float("-inf")
            right1 = nums1[i] if i < m else float("inf")
            left2 = nums2[j - 1] if j > 0 else float("-inf")
            right2 = nums2[j] if j < n else float("inf")

            # Check if partition is correct
            if left1 <= right2 and left2 <= right1:
                # Correct partition found
                if total_len % 2:  # odd total length
                    return float(max(left1, left2))
                else:  # even total length
                    return (max(left1, left2) + min(right1, right2)) / 2.0
            elif left1 > right2:
                # i is too big, move left
                hi = i - 1
            else:
                # i is too small, move right
                lo = i + 1

        # If we exit loop, inputs were invalid (e.g., both arrays empty)
        raise ValueError("Input arrays are not valid for median calculation.")

