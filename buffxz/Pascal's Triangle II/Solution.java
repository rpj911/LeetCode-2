public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();        
        List<Integer> cur = new ArrayList<Integer>();
        
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prev = cur;
            cur = new ArrayList<Integer>();
            
            for (int j = 0; j <= i; j++) {
                int curNum = 0;
                if (j > 0) curNum += prev.get(j - 1);
                if (j < i) curNum += prev.get(j);
                cur.add(curNum);
            }
        }
        
        return cur;
    }
}