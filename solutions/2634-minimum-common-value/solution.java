// class Solution {
//   public int getCommon(int[] nums1, int[] nums2) {
//     return find(nums1, nums2, 0, 0);
//   }

//   private int find(int[] nums1, int[] nums2, int i, int j) {
//     // Base case
//     if (i >= nums1.length || j >= nums2.length)
//       return -1;

//     // Common element found
//     if (nums1[i] == nums2[j])
//       return nums1[i];

//     // Move pointer of smaller element
//     if (nums1[i] < nums2[j])
//       return find(nums1, nums2, i + 1, j);
//     else
//       return find(nums1, nums2, i, j + 1);
//   }
// }

class Solution {
  public int getCommon(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j])
        return nums1[i];
      if (nums1[i] < nums2[j])
        ++i;
      else
        ++j;
    }

    return -1;
  }
}


