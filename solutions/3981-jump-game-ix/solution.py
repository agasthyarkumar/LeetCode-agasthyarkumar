class Solution:
    def maxValue(self, nums):
        n = len(nums)

        stack = []

        for i, x in enumerate(nums):

            start = i
            mn = x
            mx = x

            while stack and stack[-1][2] > mn:

                s, e, old_max = stack.pop()

                start = s
                mx = max(mx, old_max)

            stack.append((start, i, mx))

        ans = [0] * n

        for s, e, mx in stack:
            for i in range(s, e + 1):
                ans[i] = mx

        return ans
