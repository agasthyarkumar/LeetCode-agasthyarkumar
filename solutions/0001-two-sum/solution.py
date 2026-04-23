class Solution(object):
    def twoSum(self, nums, target):
        """
        Returns the indices of the two numbers in `nums` that add up to `target`.

        Parameters
        ----------
        nums : List[int]
            List of integers.
        target : int
            Desired sum of the two numbers.

        Returns
        -------
        List[int]
            A list containing the two indices.

        Raises
        ------
        ValueError
            If no two numbers sum to the target.
        """
        index_by_value = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in index_by_value:
                return [index_by_value[complement], i]
            index_by_value[num] = i
        # According to the problem statement this line should never be reached.
        raise ValueError("No two sum solution found")
