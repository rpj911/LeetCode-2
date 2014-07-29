/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> queue= new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (visited.contains(cur)) continue;
            UndirectedGraphNode temp = new UndirectedGraphNode(cur.label);
            map.put(cur,temp);
            
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                queue.offer(neighbor);
            }
            visited.add(cur);
        }
        
        for (UndirectedGraphNode key : map.keySet()) {
            UndirectedGraphNode copy = map.get(key);
            for (UndirectedGraphNode child : key.neighbors) {
                copy.neighbors.add(map.get(child));
            }
        }
        
        return map.get(node);
    }
}