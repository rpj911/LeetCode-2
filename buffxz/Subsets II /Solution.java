public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        return helper(num, 0);
    }
    
    private List<List<Integer>> helper(int[] num, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i - 1]) continue;
            int cur = num[i];
            List<List<Integer>> subRes = helper(num, i + 1);
            for (List<Integer> subList : subRes) {
                List<Integer> temp = new ArrayList<Integer>(subList);
                temp.add(0, cur);
                res.add(temp);
            }
        }
        
        return res;
    }
}