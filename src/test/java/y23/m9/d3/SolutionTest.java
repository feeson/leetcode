package y23.m9.d3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution=new Solution();
    @Test
    void eliminateMaximum() {
        int arr1[]=new int[]{1,1,2,3};
        int arr2[]=new int[]{1,1,1,1};
        System.out.println(solution.eliminateMaximum(arr1,arr2));
    }
}