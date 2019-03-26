package answer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp != null) {
                ret.add(temp.val);
                q.offer(temp.left);
                q.offer(temp.right);
            } else {
                ret.add(null);
            }
        }
        for (int i = ret.size() - 1; i >= 0; i--) {
            if (ret.get(i) == null)
                ret.remove(i);
            else
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ret.size(); ++i) {
            sb.append(ret.get(i));
            if (i != ret.size() - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2)
            return null;
        data = data.substring(1, data.length() - 1);
        String[] res = data.split(",");
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<TreeNode> children = new LinkedList<>();
        for (String i : res) {
            if (i.equals("null")) {
                nodes.addLast(null);
                children.addLast(null);
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(i));
                nodes.addLast(node);
                children.addLast(node);
            }
        }
        children.removeFirst();
        TreeNode root = nodes.getFirst();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.removeFirst();
            if (node == null)
                continue;
            if (!children.isEmpty())
                node.left = children.removeFirst();
            if (!children.isEmpty())
                node.right = children.removeFirst();
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        LeetCode297 l = new LeetCode297();
        String res = l.serialize(root);
        System.out.println(l.serialize(root));
        TreeNode node = l.deserialize(res);
        System.out.println(l.serialize(node));
        System.out.println(node.right.val);
        System.out.println(l.serialize(node));
    }
}
