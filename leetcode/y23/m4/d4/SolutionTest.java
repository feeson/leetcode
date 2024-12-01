package y23.m4.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr=new int[]{3,2,4,1};
        System.out.print(solution.mergeStones(arr,2));
    }
    @Test
    void mergeStones() {
    }
}