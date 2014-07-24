import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public static int ladderLength(String start, String end, Set<String> dict) {
        
        int n = dict.size() + 2;
        HashSet<String> visited = new HashSet<String>();
        
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);
        int step = 2;
        boolean flag = false;
        
        while (!queue.isEmpty()) {
            String curString = queue.remove();
            if (curString == null) {
                if (flag) break;
                step++;
                queue.add(null);
                flag = true;
                continue;
            }
            if (visited.contains(curString)) {
                continue;
            }
            visited.add(curString);
            flag = false;
            ArrayList<String> neighbours = getAllNeighbours(curString, dict);
            
            for (String itr : neighbours) {
                if (visited.contains(itr)) continue;
                if (itr.equals(end)) {
                    return step;
                }
                queue.add(itr);
            }
        }
        
        return 0;
    }
    
    public boolean isNeighbour(String s, String d) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != d.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        return true;
    }
    
    public void fillTable(String start, String end, ArrayList<String> list, boolean[][] table) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (j == i) continue;
                if (isNeighbour(list.get(i), list.get(j))) {
                    table[i][j] = true;
                    table[j][i] = true;
                }
            }
        }
    }
    
    public static ArrayList<String> getAllNeighbours(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            String left = "";
            String right = "";
            if (i > 0) left = s.substring(0, i);
            if (i != s.length()) right = s.substring(i + 1, s.length());
            for (char j = 'a'; j <= 'z'; j++) {
            	if (j == s.charAt(i)) continue;
                StringBuilder builder = new StringBuilder();
                builder.append(left);
                builder.append(j);
                builder.append(right);
                if (dict.contains(builder.toString())) {
                    res.add(builder.toString());
                }
            }
        }
        return res;
    }
}