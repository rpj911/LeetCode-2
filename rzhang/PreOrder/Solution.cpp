/**
 *  * Definition for binary tree
 *   * struct TreeNode {
 *    *     int val;
 *     *     TreeNode *left;
 *      *     TreeNode *right;
 *       *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 *        * };
 *         */
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        stack<TreeNode*> s;
        
        if (root != NULL)
            s.push(root);
        
        TreeNode* parent = NULL;
        
        vector<int> ret;
        
        while (!s.empty()) {
            TreeNode* cur = s.top();
            if (parent == NULL || parent->left == cur || parent->right == cur) {
                ret.push_back(cur->val);
                if (cur->left) {
                    s.push(cur->left);
                } else if (cur->right) {
                    s.push(cur->right);
                } else {
                    s.pop();
                }
            } else if (cur->left == parent) {
                if (cur->right) {
                    s.push(cur->right);
                } else {
                    s.pop();
                }
            } else {
                s.pop();
            }
            parent = cur;
        }
        
        return ret;
    }
};
