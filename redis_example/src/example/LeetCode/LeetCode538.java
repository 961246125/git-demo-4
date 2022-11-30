package example.LeetCode;

import java.util.*;

public class LeetCode538 {

    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);

    }

    public void dfsCount(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        node.val = map.get(node.val);
        dfsCount(node.left, map);
        dfsCount(node.right, map);
    }

    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        if (list.size() == 1) {
            return root;
        }
        list.sort(((o1, o2) -> o1-o2));
        int[] sum = new int[list.size()];
        Map<Integer, Integer> map = new HashMap<>();
        sum[list.size()-1] = list.get(list.size()-1);
        map.put(list.get(list.size()-1),list.get(list.size()-1));
        for (int i = list.size()-2; i >= 0; i--) {
            sum[i] = sum[i+1] + list.get(i);
            map.put(list.get(i), sum[i]);
        }
        dfsCount(root, map);
        return root;
    }

    public static void main(String[] args) {
        LeetCode538 leetCode538 = new LeetCode538();
        List<Integer> nums = Arrays.asList(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8);
        TreeNode result = leetCode538.convertBST(CreateTreeNode.createTreeNode(nums));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

    }
}
