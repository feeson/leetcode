package jiqiao.树状数组;

public class Tree {
    void init(int[]nums){
        len = nums.length;
        tree = new int[len];
        for (int i = 0;i < len;++i){
            modify(i,nums[i]);// 单点修改
        }
        tree = new int[len + 1];
        modify(0,nums[0]);
        for (int i = 0;i < len;++i){
            modify(i + 1,nums[i + 1] - nums[i]);// 单点修改
        }
    }
    int[] tree;
    int len;
    int lowbit(int x){
        return x&(-x);
    }
    void modify(int index,int val){
        while (index < len){
            tree[index]+=val;
            index+=lowbit(index);
        }
    }
    int query(int index){
        int res = 0;
        while (index >= 0){
            res += tree[index];
            index-=lowbit(index);
        }
        return res;
    }
}
