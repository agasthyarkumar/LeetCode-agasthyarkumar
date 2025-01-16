class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xorNums1 = 0;
        int xorNums2 = 0;
        
        // XOR all elements of nums1
        for (int num : nums1) {
            xorNums1 ^= num;
        }
        
        // XOR all elements of nums2
        for (int num : nums2) {
            xorNums2 ^= num;
        }
        
        int result = 0;

        // Each element of nums1 contributes to the result if nums2.length is odd
        if (nums2.length % 2 != 0) {
            result ^= xorNums1;
        }

        // Each element of nums2 contributes to the result if nums1.length is odd
        if (nums1.length % 2 != 0) {
            result ^= xorNums2;
        }

        return result;
    }
}

