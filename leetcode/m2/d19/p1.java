package y24.m2.d19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> postorder(Node root) {
        return dfs(root,new ArrayList<>());
    }
    List<Integer> dfs(Node root, List<Integer> res){
        if (root == null)
            return res;
        if (root.children!=null){
//            for (var child:root.children){
//                dfs(child,res);
//            }
        }
        res.add(root.val);
        return res;
    }
}