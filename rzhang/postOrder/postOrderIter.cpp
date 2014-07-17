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
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> ret;
        
        stack<TreeNode*> s;
        TreeNode* parent = NULL;
        if (root)
            s.push(root);
        
        while (!s.empty()) {
            TreeNode* cur = s.top();
            if (parent == NULL || parent->right == cur || parent->left == cur) {
                if (cur->left) {
                    s.push(cur->left);
                } else if(cur->right) {
                    s.push(cur->right);
                } else {
                    ret.push_back(cur->val);
                    s.pop();
                }
            } else if (cur->left == parent) {
                if (cur->right) {
                    s.push(cur->right);
                } else {
                    ret.push_back(cur->val);
                    s.pop();
                }
            } else {
                ret.push_back(cur->val);
                s.pop();
            }
            
            parent = cur;
        }
        
        return ret;
    }
};
