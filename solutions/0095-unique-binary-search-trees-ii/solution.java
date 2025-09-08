/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0)
      return new ArrayList<>();
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int mn, int mx) {
    if (mn > mx)
      return Arrays.asList((TreeNode) null);

    List<TreeNode> ans = new ArrayList<>();

    for (int i = mn; i <= mx; ++i)
      for (TreeNode left : generateTrees(mn, i - 1))
        for (TreeNode right : generateTrees(i + 1, mx)) {
          ans.add(new TreeNode(i));
          ans.get(ans.size() - 1).left = left;
          ans.get(ans.size() - 1).right = right;
        }

    return ans;
  }
}
