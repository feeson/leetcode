package y23.m11.d11;

import java.util.List;

/**
 Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。

 半开区间[left, right)表示所有left <= x < right的实数 x 。

 实现 RangeModule 类:


 RangeModule()初始化数据结构的对象。
 void addRange(int left, int right) 添加 半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。
 boolean queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回 true，否则返回 false 。
 void removeRange(int left, int right)停止跟踪 半开区间[left, right)中当前正在跟踪的每个实数。




 示例 1：

 输入
 ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 输出
 [null, null, null, true, false, true]

 解释
 RangeModule rangeModule = new RangeModule();
 rangeModule.addRange(10, 20);
 rangeModule.removeRange(14, 16);
 rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
 rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）




 提示：


 1 <= left < right <= 109
 在单个测试用例中，对addRange、 queryRange和 removeRange 的调用总数不超过104次


 */
/*
https://leetcode.cn/problems/range-module/?envType=daily-question&envId=2023-11-12
*/
class RangeModule {
    class Node{
        Node pa;
        Node ln;
        Node rn;
        boolean val;
        int lazy = 0;
    }
    int cnt=0;
    void chg(Node node,int l,int r,int tgtl,int tgtr,boolean k){
        if (l>=tgtl && r<= tgtr){
            node.lazy = k?1:-1;
            node.val = k;
            return;
        }
        int mid =(l + r)>>1;
        if (node.ln == null){
            Node left = new Node();
            left.pa = node;
            node.ln = left;
            Node right = new Node();
            right.pa = node;
            node.rn = right;
        }
        pushdown(node);
        if (mid <= tgtl)
            chg(node.rn,mid,r,tgtl,tgtr,k);
        else if (tgtr <= mid)
            chg(node.ln,l,mid,tgtl,tgtr,k);
        else{
            chg(node.rn,mid,r,tgtl,tgtr,k);
            chg(node.ln,l,mid,tgtl,tgtr,k);
        }
        node.val = node.rn.val & node.ln.val;
    }
    boolean query(Node node,int l,int r,int tgtl,int tgtr){
        if (l>=tgtl && r<= tgtr){
            if (node.lazy != 0){
                node.val = node.lazy == 1;
            }
            return node.val;
        }
        if (node.ln == null){
            Node nnl = new Node();
            nnl.pa = node;
            node.ln = nnl;
            Node nnr = new Node();
            nnr.pa = node;
            node.rn = nnr;
        }
        if (node.lazy != 0) {
            pushdown(node);
        }
        int mid = (l + r)>>1;
        if (mid <= tgtl)
            return query(node.rn,mid,r,tgtl,tgtr);
        else if (mid >= tgtr)
            return query(node.ln,l,mid,tgtl,tgtr);
        else
            return  query(node.rn,mid,r,tgtl,tgtr) & query(node.ln,l,mid,tgtl,tgtr);
    }
    void pushdown(Node node){
        if (node.lazy != 0){
            node.ln.lazy = node.lazy;
            node.ln.val = node.lazy == 1;
            node.rn.lazy = node.lazy;
            node.rn.val = node.lazy == 1;
            node.val = node.lazy == 1;
            node.lazy = 0;
        }
    }
    Node root = new Node();
    // 线段树  //动态开点
    public RangeModule() {

    }
    int oe9= (int) (1e9+1);
    public void addRange(int left, int right) {
        chg(root,0,oe9,left,right,true);
    }

    public boolean queryRange(int left, int right) {
        return query(root,0,oe9,left,right);
    }

    public void removeRange(int left, int right) {
        chg(root,0,oe9,left,right,false);
    }
}
/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */