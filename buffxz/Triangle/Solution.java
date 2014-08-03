public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> sum = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> curList = triangle.get(i);
            if (i == 0) {
                sum.add(curList);
                continue;
            }
            List<Integer> newList = new ArrayList<Integer>();
            List<Integer> prevList = sum.get(i - 1);
            for (int j = 0; j < curList.size(); j++) {
                int curSum = curList.get(j);
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (j != 0) left = prevList.get(j - 1);
                if (j != curList.size() - 1) right = prevList.get(j);
                newList.add(curSum + Math.min(left, right));
            }
            
            sum.add(newList);
        }
        
        int min = Integer.MAX_VALUE;
        List<Integer> lastRow = sum.get(sum.size() - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            if (lastRow.get(i) < min) {
                min = lastRow.get(i);
            }
        }
        
        return min;
    }
}