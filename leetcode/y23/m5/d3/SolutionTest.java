package y23.m5.d3;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] fruits={{5,8},{7,7},{8,7},{15,5},{18,8},{19,3},{25,4},{26,1},{34,10},{38,3},{39,4},{40,5}};
        solution.maxTotalFruits(fruits,6,19);
    }
}