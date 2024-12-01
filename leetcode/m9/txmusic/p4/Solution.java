package y24.m9.txmusic.p4;


import java.util.*;

/*
 *
 *
 *
 *
 *
 *
 *
 *
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] pruneSequence (TreeNode root) {
        class LevelNode implements Comparator<LevelNode>, Comparable<LevelNode>{
            public LevelNode(TreeNode node, int level, int cnt){
                this.node = node;
                this.level = level;
                this.cnt = cnt;
            }
            TreeNode node;
            int level;
            int cnt;

            @Override
            public int compare(LevelNode o1, LevelNode o2) {
                if (o1.level != o2.level)
                    return o2.level - o1.level;
                return o1.cnt- o2.cnt;
            }

            @Override
            public int compareTo(LevelNode o) {
                return this.compare(this, o);
            }
        }
        // write code here
        Map<TreeNode, Integer> level = new HashMap<>();
        mark(level, root);
        int[] cnt = new int[total + 1];
        Map<TreeNode, Integer> width = new HashMap<>();
        mark(level, width, cnt, root);
        TreeSet<LevelNode> wait = new TreeSet<>();
        wait.add(new LevelNode(root, level.get(root), width.get(root)));
        int[] res = new int[total];
        int index = 0;
        while (!wait.isEmpty()){
            LevelNode first = wait.pollFirst();
            TreeNode node = first.node;
            res[index++] = node.val;
            if (node.left != null){
                TreeNode left = node.left;
                Integer l = level.get(left);
                wait.add(new LevelNode(left, l, width.get(left)));
            }
            if (node.right != null){
                TreeNode left = node.right;
                Integer l = level.get(left);
                wait.add(new LevelNode(left, l, width.get(left)));
            }
        }
        return res;
    }
    int total = 0;
    int mark(Map<TreeNode, Integer> level, TreeNode node){
        if (node == null){
            return 0;
        }
        int max = -1;
        max = Math.max(mark(level, node.left), mark(level, node.right));
        level.put(node, max);
        total++;
        return max + 1;
    }
    void mark(Map<TreeNode, Integer> level, Map<TreeNode, Integer> width, int[] cnt, TreeNode node){
        if (node == null)
            return;
        Integer l = level.get(node);
        width.put(node, cnt[l]);
        cnt[l]++;
        mark(level, width, cnt, node.left);
        mark(level, width, cnt, node.right);
    }

    public static void main(String[] args) {
        TreeNode[] v = new TreeNode[8];
        for (int i = 0; i < 8; ++i){
            v[i] = new TreeNode(i);
        }
        v[1].left = v[2];
        v[1].right = v[3];
        v[2].left = v[4];
        v[2].right = v[5];
        v[3].right = v[6];
        v[4].right = v[7];
        Solution solution = new Solution();
        solution.pruneSequence(v[1]);
    }
}