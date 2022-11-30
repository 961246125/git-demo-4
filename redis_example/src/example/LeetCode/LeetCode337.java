package example.LeetCode;

import java.util.*;

public class LeetCode337 {

    public void dfs(TreeNode node, Map<TreeNode, Integer> gMap, Map<TreeNode, Integer> fMap) {
        if (node.left == null && node.right == null) {
            gMap.put(node, node.val);
            fMap.put(node, 0);
            return;
        }
        if (node.left != null) {
            dfs(node.left, gMap, fMap);
        }
        if (node.right != null) {
            dfs(node.right, gMap, fMap);
        }
        int fLeft = fMap.getOrDefault(node.left, 0);
        int fRight = fMap.getOrDefault(node.right, 0);
        int gLeft = gMap.getOrDefault(node.left, 0);
        int gRight = gMap.getOrDefault(node.right, 0);
        gMap.put(node, node.val + fLeft + fRight);
        fMap.put(node, Math.max(gLeft, fLeft) + Math.max(gRight, fRight));
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> gMap = new HashMap<>();
        Map<TreeNode, Integer> fMap = new HashMap<>();
        dfs(root, gMap, fMap);
        return Math.max(gMap.get(root), fMap.get(root));
    }

    public static void main(String[] args) {
        LeetCode337 leetCode337 = new LeetCode337();
        List<Integer> nums = Arrays.asList(3,2,3,null,3,null,1);
        int result = leetCode337.rob(CreateTreeNode.createTreeNode(nums));
        System.out.println(result);
    }
}
