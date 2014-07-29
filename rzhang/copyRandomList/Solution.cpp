/**
 *  * Definition for singly-linked list with a random pointer.
 *   * struct RandomListNode {
 *    *     int label;
 *     *     RandomListNode *next, *random;
 *      *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 *       * };
 *        */
class Solution {
    RandomListNode* helper(unordered_map<RandomListNode*, RandomListNode*>& map, RandomListNode* node) {
        if (node == NULL) {
            return NULL;
        }
        if (map.find(node) != map.end()) {
            return map[node];
        } else {
            RandomListNode* ret = new RandomListNode(node->label);
            map[node] = ret;
            ret->next = helper(map, node->next);
            ret->random = helper(map, node->random);
            return ret;
        }
    }
    
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        unordered_map<RandomListNode*, RandomListNode*> pmap;
        
        RandomListNode* ret = helper(pmap, head);
        
        return ret;
    }
};
