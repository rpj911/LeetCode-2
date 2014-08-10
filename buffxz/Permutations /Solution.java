public class Solution {
    public List<List<Integer>> permute(int[] num) {
        return helper(num);
    }
    
    private List<List<Integer>> helper(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length == 1) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(num[0]);
            res.add(temp);
            return res;
        }
        
        for (int i = 0; i < num.length; i++) {
            int[] subArray = getSubArray(num, i);
            List<List<Integer>> subRes = helper(subArray);
            for (List<Integer> list : subRes) {
                List<Integer> temp = new ArrayList<Integer>(list);
                temp.add(num[i]);
                res.add(temp);
            }
        }
        
        return res;
    }
    
    private int[] getSubArray(int[] num, int index) {
        int[] s = new int[num.length - 1];
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (i == index) continue;
            s[count++] = num[i];
        }
        return s;
    }
}