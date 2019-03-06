package answer.leetcode;

import java.util.Stack;

// Definition for a Node.

public class LeetCode430 {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;
        Node now = head;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (now.child == null && now.next != null)
                now = now.next;
            if (now.next != null) {
                stack.push(now.next);
                now.next = now.child;
                now.next.prev = now;
                now.child = null;
            } else if (!stack.empty()) {
                now.next = stack.pop();
                now.next.prev = now;
            } else if(now.child!=null){
                now.next = now.child;
                now.next.prev = now;
                now.child = null;
            }else
                break;
        }
        return head;
    }
}
