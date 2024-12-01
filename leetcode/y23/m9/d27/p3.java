package y23.m9.d27;

import y22.m09.d27.p1.Solution;

import java.util.*;

/**
 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：



 BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 int next()将指针向右移动，然后返回指针处的数字。


 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。



 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 的中序遍历中至少存在一个下一个数字。



 示例：

 输入
 ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 输出
 [null, 3, 7, true, 9, true, 15, true, 20, false]

 解释
 BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 bSTIterator.next();    // 返回 3
 bSTIterator.next();    // 返回 7
 bSTIterator.hasNext(); // 返回 True
 bSTIterator.next();    // 返回 9
 bSTIterator.hasNext(); // 返回 True
 bSTIterator.next();    // 返回 15
 bSTIterator.hasNext(); // 返回 True
 bSTIterator.next();    // 返回 20
 bSTIterator.hasNext(); // 返回 False




 提示：


 树中节点的数目在范围 [1, 105] 内
 0 <= Node.val <= 106
 最多调用 105 次 hasNext 和 next 操作




 进阶：


 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。


 */
/*
https://leetcode.cn/problems/binary-search-tree-iterator/?envType=study-plan-v2&envId=top-interview-150
*/



class BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<TreeNode,TreeNode> pa=new HashMap<>();
    Set<TreeNode> used=new HashSet<>();
    TreeNode next=null;
    public BSTIterator(TreeNode root) {
        next=root;
        pa.put(next,null);
        while (next.left!=null){
            TreeNode t=next;
            next=next.left;
            pa.put(next,t);
        }
    }

    public int next() {
        used.add(next);
        int val=next.val;
        if (next.right==null||pa.containsKey(next.right)){
            next=pa.get(next);
            while (used.contains(next))
                next=pa.get(next);
            return val;
        }
        TreeNode t=next;
        next=next.right;
        pa.put(next,t);
        while (next.left!=null){
            t=next;
            next=next.left;
            pa.put(next,t);
        }
        return val;
    }

    public boolean hasNext() {
        return next!=null;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(7,new TreeNode(3),new TreeNode(15,new TreeNode(9),new TreeNode(20)));
        BSTIterator bstIterator=new BSTIterator(treeNode);
        while (bstIterator.hasNext())
            System.out.println(bstIterator.next());
    }

}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */