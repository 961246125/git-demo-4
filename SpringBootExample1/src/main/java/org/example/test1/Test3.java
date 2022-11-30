package org.example.test1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Test3 {
    class TreeNode{
        int val;
        List<TreeNode> listNode;
        public TreeNode(){}
        public TreeNode(int val){this.val = val;}
    }

    public void dfs(TreeNode node, List<Integer> result){
        if (node == null) {
            return;
        }
        result.add(node.val);
        List<TreeNode> temp = node.listNode;
        for (TreeNode tempNode : temp) {
            dfs(tempNode, result);
        }
    }

    public List<Integer> dfsTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result);

        return result;
    }

    public List<Integer> bfsTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            result.add(tempNode.val);
            List<TreeNode> temp = tempNode.listNode;
            for (TreeNode everyNode : temp) {
                queue.add(everyNode);
            }
        }
        return result;
    }
}
