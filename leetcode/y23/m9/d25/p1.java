package y23.m9.d25;

import java.util.*;
import java.util.function.IntFunction;

/**
 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。

 实现 LFUCache 类：


 LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
 int get(int key)- 如果键key 存在于缓存中，则获取键的值，否则返回 -1 。
 void put(int key, int value)- 如果键key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。


 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。

 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。

 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。



 示例：

 输入：
 ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 输出：
 [null, null, null, 1, null, -1, 3, null, -1, 3, 4]

 解释：
 // cnt(x) = 键 x 的使用计数
 // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 LFUCache lfu = new LFUCache(2);
 lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 lfu.get(1);      // 返回 1
 // cache=[1,2], cnt(2)=1, cnt(1)=2
 lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 // cache=[3,1], cnt(3)=1, cnt(1)=2
 lfu.get(2);      // 返回 -1（未找到）
 lfu.get(3);      // 返回 3
 // cache=[3,1], cnt(3)=2, cnt(1)=2
 lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 // cache=[4,3], cnt(4)=1, cnt(3)=2
 lfu.get(1);      // 返回 -1（未找到）
 lfu.get(3);      // 返回 3
 // cache=[3,4], cnt(4)=1, cnt(3)=3
 lfu.get(4);      // 返回 4
 // cache=[3,4], cnt(4)=2, cnt(3)=3



 提示：


 1 <= capacity<= 104
 0 <= key <= 105
 0 <= value <= 109
 最多调用 2 * 105 次 get 和 put 方法


 */
/*
https://leetcode.cn/problems/lfu-cache/?envType=daily-question&envId=2023-09-25
*/
class LFUCache {
    class CntBlock{
        int key;
        CntBlock pre;
        CntBlock next;
    }
    class Info{
        int value;
        int cnt;
        CntBlock cntBlock;
    }
    Map<Integer,Info> map=new HashMap<>();
    ArrayList<CntBlock> cnts=new ArrayList<>();
    int capacity;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        CntBlock head=new CntBlock();
        cnts.add(head);
        head.pre=head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Info info = map.get(key);
            rmv(info);
            return map.get(key).value;
        }
        else
            return -1;
    }

    private void rmv(Info info) {
        info.cntBlock.pre.next=info.cntBlock.next;
        if (info.cntBlock.next!=null)
            info.cntBlock.next.pre=info.cntBlock.pre;
        if (cnts.get(info.cnt).pre== info.cntBlock)
            cnts.get(info.cnt).pre= info.cntBlock.pre;
        info.cnt++;
        if (cnts.size()<=info.cnt){
            CntBlock head=new CntBlock();
            cnts.add(head);
            head.pre=head;
        }
        cnts.get(info.cnt).pre.next= info.cntBlock;
        info.cntBlock.pre=cnts.get(info.cnt).pre;
        info.cntBlock.next=null;
        cnts.get(info.cnt).pre= info.cntBlock;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Info info = map.get(key);
            info.value=value;
            rmv(info);
        }else {
            if (map.size()==capacity){
                int i=0;
                for (;i<cnts.size();++i){
                    if (cnts.get(i).next!=null)
                        break;
                }
                CntBlock cntBlock = cnts.get(i).next;
                map.remove(cntBlock.key);
                cntBlock.pre.next=cntBlock.next;
                if (cntBlock.next!=null)
                    cntBlock.next.pre=cntBlock.pre;
                if (cnts.get(i).pre==cntBlock) {
                    cnts.get(i).pre=cntBlock.pre;
                }
            }
            CntBlock cntBlock=new CntBlock();
            cntBlock.key=key;
            Info info=new Info();
            info.value=value;
            info.cnt=1;
            info.cntBlock=cntBlock;
            map.put(key, info);
            if (cnts.size()<=1){
                CntBlock head=new CntBlock();
                cnts.add(head);
                head.pre=head;
            }
            CntBlock head = cnts.get(1);
            head.pre.next=cntBlock;
            cntBlock.pre=head.pre;
            head.pre=cntBlock;
        }
    }

//    public static void main(String[] args) {
//        LFUCache lfuCache=new LFUCache(3);
//        lfuCache.put(1,1);
//        lfuCache.put(2,2);
//        lfuCache.put(3,3);
//        lfuCache.put(4,4);
//        lfuCache.get(4);
//        lfuCache.get(3);
//        lfuCache.get(2);
//        lfuCache.get(1);
//        lfuCache.put(5,5);
//        lfuCache.put(4,4);
//        lfuCache.get(1);
//        lfuCache.get(2);
//        lfuCache.get(3);
//        lfuCache.get(4);
//        lfuCache.get(5);
//    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */