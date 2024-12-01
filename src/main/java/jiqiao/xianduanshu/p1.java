package jiqiao.xianduanshu;

public class p1 {
    class Node{
        int sum;
        int l;
        int r;
        int lz;
    }
    Node[] nodes;

    void push(int id, int l, int r){
        if (nodes[id].lz != 0){
            int mid = (l + r)/2;
            nodes[id * 2].lz += nodes[id].lz;
            nodes[id*2 + 1].lz += nodes[id].lz;
            nodes[id * 2].sum += nodes[id].lz*(mid - l + 1);
            nodes[id * 2 + 1].sum += nodes[id].lz*(r - mid);
            nodes[id].lz = 0;
        }
    }

    void build(int id, int l, int r, int x, int y, int val){
        if (l >= x && r <= y) {
            nodes[id].lz += val;
            nodes[id].sum += (r - l + 1) * val;
            return;
        }
        push(id, l, r);
        int mid = (l + r)/2;
        if (x <= mid)
            build(id*2, l, mid, x, y, val);
        if (y > mid)
            build(id * 2 + 1, mid + 1, r, x, y, val);
        nodes[id].sum = nodes[id * 2].sum + nodes[id * 2 + 1].sum;
    }

    int search(int id, int l, int r, int x, int y){
        if (x <= l && y >= r){
            return nodes[id].sum;
        }
        push(id, l, r);
        int mid = (l + r)/2;
        int res = 0;
        if (x <= mid)
            res += search(id * 2, l, mid, x, y);
        if (y > mid)
            res += search(id * 2 + 1, mid + 1, r, x, y);
        return res;
    }

}
