package y23.m4.d3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr=new int[]{3,1,1,3};
        arr=solution.prevPermOpt1(arr);
        Arrays.stream(arr).forEach(value -> {System.out.print(value);});
    }
    @Test
    void prevPermOpt1() {
    }
}