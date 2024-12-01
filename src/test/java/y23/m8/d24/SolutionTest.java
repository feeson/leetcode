package y23.m8.d24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution=new Solution();
    @Test
    void countServers() {
        int [][] data={
                {1,0,0,0,0,0},
                {0,0,1,1,1,1},
                {0,0,0,0,0,0},
                {1,0,1,0,0,0},
                {0,0,0,0,0,1}};
        int i = solution.countServers(data);
        System.out.println(i);
    }
}