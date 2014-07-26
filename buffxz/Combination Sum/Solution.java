public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> iniList = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(candidates, target, iniList, set, res);
        
        return res;
    }
    
    public void helper(int[] candidates, int target, List<Integer> curList, Set<List<Integer>> set, List<List<Integer>> res) {
        
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] < target && (curList.size() == 0 || candidates[i] >= curList.get(curList.size() - 1))) {
                List<Integer> addList = new ArrayList<Integer>();
                addList.addAll(curList);
                addList.add(candidates[i]);
                helper(candidates, target - candidates[i], addList, set, res);
            } else if (candidates[i] == target & (curList.size() == 0 || candidates[i] >= curList.get(curList.size() - 1))) {
                List<Integer> addList = new ArrayList<Integer>();
                addList.addAll(curList);
                addList.add(candidates[i]);
                if (!set.contains(addList)) {
                    res.add(addList);
                    set.add(addList);
                }
            }
        }
    }
}