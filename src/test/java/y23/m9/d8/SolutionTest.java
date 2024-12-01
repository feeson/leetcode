package y23.m9.d8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution=new Solution();
    @Test
    void maxSumDivThree() {
        int[]arr=new int[]{1,2,3,4,4};
        System.out.println(solution.maxSumDivThree(arr));
    }
}