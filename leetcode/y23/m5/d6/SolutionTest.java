package y23.m5.d6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String str="crcoakroak";
        solution.minNumberOfFrogs(str);
    }

    @Test
    void minNumberOfFrogs() {
        Solution solution=new Solution();
        String str="crcoakroak";
        Assertions.assertEquals(2,solution.minNumberOfFrogs(str));
    }
}