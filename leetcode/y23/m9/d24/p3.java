package y23.m9.d24;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.IllegalFormatCodePointException;
import java.util.List;

class Solutionp3 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int len=maxHeights.size();
        if (len==1)
            return maxHeights.get(0);
        long[] sumPre=new long[len];
        Deque<Long> deque=new ArrayDeque<>();
        Deque<Long> tmp=new ArrayDeque<>();
        long sum=0;
        for (int i=0;i<len;++i){
            long val=maxHeights.get(i);
            tmp.addLast(val);
            while (!deque.isEmpty()&&deque.peek()>val){
                sum-=deque.pollFirst();
                tmp.addLast(val);
            }
            while (!tmp.isEmpty()){
                deque.addFirst(tmp.pollLast());
                sum+=val;
            }
            sumPre[i]=sum;
        }
        long[] sumTail=new long[len];
        deque.clear();
        sum=0;
        for (int i=len-1;i>=0;i--){
            long val=maxHeights.get(i);
            tmp.addLast(val);
            while (!deque.isEmpty()&&deque.peek()>val){
                sum-=deque.pollFirst();
                tmp.addLast(val);
            }
            while (!tmp.isEmpty()){
                deque.addFirst(tmp.pollLast());
                sum+=val;
            }
            sumTail[i]=sum;
        }
        long res=0;
        for (int i=0;i<len;++i){
            if (i>0&&i<len-1){
                long val=sumPre[i]+sumTail[i]-maxHeights.get(i);
                res=Math.max(res,val);
            }else if (i==0){
                res=Math.max(res, sumTail[0]);
            }else {
                res=Math.max(res,sumPre[len-1]);
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        System.out.println(solution.maximumSumOfHeights(List.of(1000000000,999999999,999999998)));
//    }
}