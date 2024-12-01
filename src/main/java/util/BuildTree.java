package util;

import Bean.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BuildTree {
    public static TreeNode buildTree(Integer[]arr){
        if (arr==null)
            return null;
        Deque<TreeNode> deque=new LinkedList<>();
        for (Integer val:arr){
            if (val==null)
                deque.addLast(null);
            else
                deque.addLast(new TreeNode(val));
        }
        TreeNode root=deque.peekFirst();
        Deque<TreeNode> waiting=new ArrayDeque<>();
        waiting.addLast(deque.pollFirst());
        while (!deque.isEmpty()){
            TreeNode node=waiting.pollFirst();
            if (deque.isEmpty())
                break;
            node.left=deque.pollFirst();
            if (node.left!=null)
                waiting.addLast(node.left);
            if (deque.isEmpty())
                break;
            node.right=deque.pollFirst();
            if (node.right!=null)
                waiting.addLast(node.right);
        }
        return root;
    }

//    public static void main(String[] args) {
//        Integer[]arr=new Integer[]{32,26,47,19,null,null,56,null,27};
//        BuildTree buildTree=new BuildTree();
//        TreeNode treeNode = buildTree.buildTree(arr);
//        System.out.println(treeNode);
//    }
}
