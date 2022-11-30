package example.LeetCode;

import example.LeetCode.TreeNode;

import java.util.List;

public class CreateTreeNode {

    static public void dfs(TreeNode node, List<Integer> nums, int index) {
        int left = 2*index+1;
        int right = 2*index+2;
        if (left < nums.size() && nums.get(left) != null) {
            TreeNode leftNode = new TreeNode(nums.get(left));
            node.left = leftNode;
            dfs(leftNode, nums, left);
        }
        if (right < nums.size() && nums.get(right) != null) {
            TreeNode rightNode = new TreeNode(nums.get(right));
            node.right = rightNode;
            dfs(rightNode, nums, right);
        }
    }

     static public TreeNode createTreeNode(List<Integer> nums) {
        TreeNode root = new TreeNode(nums.get(0));
        dfs(root, nums, 0);
        return root;
    }
}
