package y23.m3.d31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int arr[]=new int[]{4,5,6,7,8,9};
        System.out.println(solution.arithmeticTriplets(arr,2));
    }

    @Test
    void arithmeticTriplets() {

    }
}