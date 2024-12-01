package y23.m9.d23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给你一棵n个节点的树，编号从0到n - 1，以父节点数组parent的形式给出，其中parent[i]是第i个节点的父节点。树的根节点为 0号节点，所以parent[0] = -1，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。

 数据结构需要支持如下函数：


 Lock：指定用户给指定节点 上锁，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 Unlock：指定用户给指定节点 解锁，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 Upgrade：指定用户给指定节点上锁，并且将该节点的所有子孙节点解锁。只有如下 3 个条件 全部 满足时才能执行升级操作：

 指定节点当前状态为未上锁。
 指定节点至少有一个上锁状态的子孙节点（可以是 任意用户上锁的）。
 指定节点没有任何上锁的祖先节点。




 请你实现LockingTree类：


 LockingTree(int[] parent)用父节点数组初始化数据结构。
 lock(int num, int user) 如果id 为user的用户可以给节点num上锁，那么返回true，否则返回false。如果可以执行此操作，节点num会被 id 为 user的用户 上锁。
 unlock(int num, int user)如果 id 为 user的用户可以给节点 num解锁，那么返回true，否则返回 false。如果可以执行此操作，节点 num变为 未上锁状态。
 upgrade(int num, int user)如果 id 为 user的用户可以给节点 num升级，那么返回true，否则返回 false。如果可以执行此操作，节点 num会被升级 。




 示例 1：



 输入：
 ["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"]
 [[[-1, 0, 0, 1, 1, 2, 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]
 输出：
 [null, true, false, true, true, true, false]

 解释：
 LockingTree lockingTree = new LockingTree([-1, 0, 0, 1, 1, 2, 2]);
 lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
 // 节点 2 被用户 2 上锁。
 lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
 lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
 // 节点 2 现在变为未上锁状态。
 lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
 // 节点 4 被用户 5 上锁。
 lockingTree.upgrade(0, 1); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
 // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
 lockingTree.lock(0, 1);    // 返回 false ，因为节点 0 已经被上锁了。




 提示：


 n == parent.length
 2 <= n <= 2000
 对于i != 0，满足0 <= parent[i] <= n - 1
 parent[0] == -1
 0 <= num <= n - 1
 1 <= user <= 104
 parent表示一棵合法的树。
 lock，unlock和upgrade的调用总共不超过2000次。


 */
/*
https://leetcode.cn/problems/operations-on-tree/?envType=daily-question&envId=2023-09-23
*/
class LockingTree {
    List<Integer>[] childs;
    int[] lock;
    int[] parent;
    int len;
    public LockingTree(int[] parent) {
        this.parent=parent;
        len= parent.length;
        lock=new int[len];
        Arrays.fill(lock,-1);
        childs=new List[len];
        for (int i=1;i<len;++i){
            int pa= parent[i];
            if (childs[pa]==null)
                childs[pa]=new ArrayList<>();
            childs[pa].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (lock[num]==-1){
            lock[num]=user;
            return true;
        }else
            return false;
    }

    public boolean unlock(int num, int user) {
        if (lock[num]==-1)
            return false;
        if (lock[num]!=user)
            return false;
        lock[num]=-1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (lock[num]!=-1)
            return false;
        int pa=parent[num];
        while (pa!=-1){
            if (lock[pa]!=-1)
                return false;
            pa=parent[pa];
        }
        boolean flag=false;
        if (childs[num]==null)
            return false;
        for (int child:childs[num]){
            flag|=dfs(child);
        }
        if (flag)
            lock[num]=user;
        return flag;
    }
    boolean dfs(int index){
        boolean flag=false;
        if (lock[index]!=-1){
            flag=true;
            unlock(index,lock[index]);
        }
        if (childs[index]==null)
            return flag;
        for (int child:childs[index]){
            flag|=dfs(child);
        }
        return flag;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */