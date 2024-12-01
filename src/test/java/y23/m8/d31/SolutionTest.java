package y23.m8.d31;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.SourceDataLine;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution=new Solution();
    @Test
    void minTrioDegree() {
        int n=15;
        int arr[][]=new int[][]{{6,12},{12,7},{6,15},{14,1},{14,7},{4,6},{9,2},{5,13},{4,15},{9,5},{9,8},{9,11},{2,5},{10,12},{15,2},{2,11},{2,8},{1,12},{15,5},{7,1},{15,8},{15,14},{6,5},{12,3},{12,9},{4,5},{9,1},{9,4},{10,5},{13,4},{2,4},{11,10},{13,1},{2,7},{1,11},{6,1},{2,10},{1,5},{15,7},{8,14},{7,3},{7,9},{6,10},{12,5},{12,11},{4,7},{12,8},{14,11},{3,8},{3,14},{5,11},{8,4},{9,3},{8,1},{5,14},{10,4},{5,8},{11,3},{10,1},{10,7},{1,4},{9,15},{2,3},{11,15},{13,6},{7,11},{6,9},{7,8}};
        System.out.println(solution.minTrioDegree(n,arr));
    }
}