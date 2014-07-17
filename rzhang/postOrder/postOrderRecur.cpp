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
    void helper(vector<int>& res, TreeNode* node) {
        if (node) {
            helper(res,node->left);
            helper(res,node->right);
            res.push_back(node->val);
        }
    }
public:
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> ret;
        helper(ret, root);
        return ret;
    }
};
