package y22.m10.d04.p2;


import java.util.HashMap;
import java.util.HashSet;

//class Solution {
//    int _k;
//    HashSet<Integer> hashSet;
//    boolean res=false;
//    public boolean findTarget(TreeNode root, int k) {
//        this._k=k;
//        hashSet=new HashSet<>();
//        walkTree(root);
//        if (res)
//            return true;
//        else
//            return false;
//    }
//    void walkTree(TreeNode node){
//        if (doLogical(node.val))
//            return;
//        if (node.left==null&&node.right==null) {
//            return;
//        }
//        if (node.left==null) {
//            walkTree(node.right);
//        }else if (node.right==null){
//            walkTree(node.left);
//        }else {
//            walkTree(node.left);
//            walkTree(node.right);
//        }
//    }
//    boolean doLogical(int num){
//        if (hashSet.contains(_k-num)){
//            res=true;
//            return true;
//        }else {
//            hashSet.add(num);
//            return false;
//        }
//    }
//}
class Solution {
    HashSet<Integer> hashSet = new HashSet<>();
    int _k;
    public boolean findTarget(TreeNode root, int k) {
        _k=k;
        try {
            walkTree(root);
        }catch (Exception e){
            return true;
        }
        return false;
    }

    void walkTree(TreeNode node) {
        doLogical(node.val);
        if (node.left != null)
            walkTree(node.left);
        if (node.right != null)
            walkTree(node.right);
    }

    void doLogical(int val) {
        if (hashSet.contains(_k-val)){
            int i=1/0;
            return;
        }else {
            hashSet.add(val);
        }
    }
}