package y23.m9.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution=new Solution();
    @Test
    void minWindow() {
        System.out.println(solution.minWindow(
                "ADOBECODEBANC"
                ,
                "ABC"
        ));
    }
}