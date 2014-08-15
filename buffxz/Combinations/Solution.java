public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return helper(1, n, k);        
    }
    
    private List<List<Integer>> helper(int start, int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 1) {
            for (int i = start; i <= n; i++) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                res.add(temp);
            }
            return res;
        }
        
        for (int i = start; i <= n - k + 1; i++) {
            List<List<Integer>> subRes = helper(i + 1, n, k - 1);
            for (List<Integer> list : subRes) {
                List<Integer> temp = new ArrayList<Integer>(list);
                temp.add(0, i);
                res.add(temp);
            }
        }
        return res;
    }
}