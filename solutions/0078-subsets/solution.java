
/*class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> answer=new ArrayList<>();
    solve(nums, 0,answer , result);
    return result;
  }

  private void solve(int[] nums, int s, List<Integer> answer, List<List<Integer>> result) {
    result.add(new ArrayList<>(answer));

    for (int i = s; i < nums.length; ++i) {
      answer.add(nums[i]);
      solve(nums, i + 1, answer, result);
      answer.remove(answer.size() - 1);
    }
  }
}*/
class Solution
{
    public void solve(int[] nums,List<Integer> list,List<List<Integer>> result,int i)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(list)); 
            return;
        }
        else 
        {
            list.add(nums[i]); 
            solve(nums,list,result,i+1); 
            list.remove(list.size()-1); 
            solve(nums,list,result,i+1);
        }
    }
    public List<List<Integer>> subsets(int[] nums)
    {
       List<List<Integer>> result = new ArrayList<>(); 
       List<Integer> list = new ArrayList<>(); 
       solve(nums,list,result,0); 
       return result;
    }
}
