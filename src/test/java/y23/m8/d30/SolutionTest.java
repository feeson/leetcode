package y23.m8.d30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution=new Solution();

    @Test
    void minimumJumps() {
        int arr[]=new int[]
                {1998}
                ;
        int a=1999;
        int b=2000;
        int x=2000;
        long l = System.currentTimeMillis();
        System.out.println(solution.minimumJumps(arr,a,b,x));
        System.out.println(System.currentTimeMillis()-l+"ms");
    }
}