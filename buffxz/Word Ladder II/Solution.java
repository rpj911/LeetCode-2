import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        Set<String> visited = new HashSet<String>();
        
        Queue<Wrapper> queue = new LinkedList<Wrapper>();
        queue.add(new Wrapper(start));
        queue.add(null);
        boolean flag = false;
        boolean find = false;
        
        visited.add(start);
        Set<String> curLayer = new HashSet<String>();
        Map<String, Wrapper> map = new HashMap<String, Wrapper>();
        
        dict.add(end);
        dict.add(start);
        
        while (!queue.isEmpty()) {
            Wrapper cur = queue.poll();
            if (cur == null) {
                for (String itrString : map.keySet()) {
                	queue.offer(map.get(itrString));
                }
                if (flag || find) break;
                flag = true;
                
                visited.addAll(curLayer);
                curLayer.clear();
                
                queue.add(null);
                
                map.clear();
                
                continue;
            }
            
            flag = false;
            
            List<String> list = getAllNeighbours(cur.cur, dict, visited);
            for (String itr : list) {
                if (itr.equals(end)) find = true;
                Wrapper wrapper = null;
                if (map.get(itr) != null) {
                    wrapper = map.get(itr);
                } else {
                    wrapper = new Wrapper(itr);
                }
                wrapper.addParent(cur);
                map.put(itr, wrapper);
                curLayer.add(itr);
            }
        }
        
        if (find) {
            for (Wrapper wrapper : queue) {
                if (wrapper.cur.equals(end)) {
                    List<List<String>> temp = formPath(wrapper);
                    res.addAll(temp);
                }
            }
        }
        
        return res;
    }
    
    public static List<String> getAllNeighbours(String s, Set<String> dict, Set<String> visited) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
            	if (j == s.charAt(i)) continue;
                StringBuilder builder = new StringBuilder(s);
                builder.setCharAt(i, j); 
                String temp = builder.toString();
                if (dict.contains(builder.toString())) {
                    if (visited.contains(temp)) continue;
                    res.add(temp);
                }
            }
        }
        return res;
    }
    
    public static List<List<String>> formPath(Wrapper wrapper) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        if (wrapper.parent.size() == 0) {
            List<String> subRes = new ArrayList<String>();
            subRes.add(wrapper.cur);
            res.add(subRes);
            return res;
        }
        
        for (int i = 0; i < wrapper.parent.size(); i ++) {
            Wrapper parent = wrapper.parent.get(i);
            List<List<String>> subRes = formPath(parent);
            for (List<String> temp : subRes) {
                temp.add(wrapper.cur);
                res.add(temp);
            }
        }

        return res;
    }
    
    public static class Wrapper {
        String cur;
        ArrayList<Wrapper> parent;
        int index;
        int count;
        Wrapper(String cur) {
            this.cur = cur;
            this.parent = new ArrayList<Wrapper>(100);
            this.index = 0;
            this.count = -1;
        }
        
        public void addParent(Wrapper toAdd) {
            parent.add(toAdd);
            count++;
        }
    }

}