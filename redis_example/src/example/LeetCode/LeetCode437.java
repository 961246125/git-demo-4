package example.LeetCode;

import java.util.*;

public class LeetCode437 {

    public int dfs(TreeNode node, int targetSum) {
        int ret = 0;
        if (node.val == targetSum) {
            ret++;
        }
        if (node.left == null && node.right == null) {
            return ret ;
        }
        if (node.left != null) {
            ret += dfs(node.left, targetSum - node.val);
        }
        if (node.right != null) {
            ret += dfs(node.right, targetSum - node.val);
        }
        return ret;
    }

    public int dfsPath(TreeNode node, int targetSum) {
        int ret = dfs(node, targetSum);
        if (node.left == null && node.right == null) {
            return 0;
        }
        if (node.left != null) {
            ret += dfsPath(node.left, targetSum);
        }
        if (node.right != null) {
            ret += dfsPath(node.right, targetSum);
        }
        return ret;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfsPath(root, targetSum);
    }

    public static void main(String[] args) {
        LeetCode437 leetCode437 = new LeetCode437();
        List<Integer> nums = Arrays.asList(1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000);
        int result = leetCode437.pathSum(CreateTreeNode.createTreeNode(nums), 0);
        System.out.println(result);
    }
}
