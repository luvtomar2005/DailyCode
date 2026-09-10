/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
    int result = 0;

public:
    int averageOfSubtree(TreeNode* root) {
        helper(root);
        return result;
    }

    vector<int> helper(TreeNode* root) {
        if (root == nullptr)
            return {0, 0};

        vector<int> left = helper(root->left);
        vector<int> right = helper(root->right);
        int sum = left[0] + right[0] + root->val;
        int count = left[1] + right[1] + 1;
        int average = sum / count;
        if (average == root->val)
            result++;
        return {sum, count};
    }
};