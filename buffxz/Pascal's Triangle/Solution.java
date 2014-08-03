public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            
            if (i == 0) {
                temp.add(1);
                res.add(temp);
                continue;
            }
            List<Integer> prev = res.get(i - 1);
            
            for (int j = 0; j < i + 1; j++) {
                int cur = 0;
                if (j > 0) cur += prev.get(j - 1);
                if (j < i) cur += prev.get(j);
                temp.add(cur);
            }
            res.add(temp);
        }
        
        return res;
    }
}