public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        int insertor = S[0];
        int[] sub = new int[S.length - 1];
        System.arraycopy(S, 1, sub, 0, S.length - 1);
        result = helper(insertor, sub);
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> helper(int insertor, int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (S.length == 0) {
            // add itself
            ArrayList<Integer> subRes = new ArrayList<Integer>();
            subRes.add(insertor);
            result.add(subRes);
            // add empty
            ArrayList<Integer> emptyList =new ArrayList<Integer>();
            result.add(emptyList);
            return result;
        }
        
        int newInsertor = S[0];
        int[] sub = new int[S.length - 1];
        System.arraycopy(S, 1, sub, 0, S.length - 1);
        ArrayList<ArrayList<Integer>> prevRes = helper(newInsertor, sub);
        
        result.addAll(prevRes);
        for (ArrayList<Integer> subPrevRes : prevRes) {
            ArrayList<Integer> newSubPrevRes = new ArrayList<Integer>(subPrevRes);
            newSubPrevRes.add(0, insertor);
            result.add(newSubPrevRes);
        }
        
        return result;
    }
}







