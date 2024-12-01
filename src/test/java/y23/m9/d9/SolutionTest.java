package y23.m9.d9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution=new Solution();
    @Test
    void canFinish() {
        int t=5;
        int[][] arr=new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(solution.canFinish(5,arr));
    }
}