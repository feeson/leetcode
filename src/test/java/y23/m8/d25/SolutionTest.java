package y23.m8.d25;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solutionp2 solutionp2 =new Solutionp2();
    @Test
    void largestNumber() {
        int []arr=new int[]{6,10,15,40,40,40,40,40,40};
        String s = solutionp2.largestNumber(arr, 47);
        System.out.println(s);
    }

    Solution solution=new Solution();
    @Test
    void minSideJumps() {
        int[]arr=new int[]{0,1,2,3,0};
        int i = solution.minSideJumps(arr);
        System.out.println(i);
    }
}