public class Solution {
    public List<String> generateParenthesis(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        dfs(count, sb, res, n);
        return res;
    }
    
    private void dfs(int count, StringBuilder sb, List<String> res, int n) {
        if (count > sb.length() / 2) {
            return;
        }
        
        if (sb.length() == n * 2) {
            if (count == n) {
                res.add(sb.toString());
            }
            return;
        }
        
        sb.append('(');
        dfs(count, sb, res, n);
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append(')');
        dfs(count + 1, sb, res, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}