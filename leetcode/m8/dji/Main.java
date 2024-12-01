package y24.m8.dji;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int numberOfPatrolBlocks(int[][] block) {
        m = block.length;
        n = block[0].length;

        int res = 1;
        block[0][0] = 2;
        donext();
        int turns = 0;
        while (true){
            if (turns >= 4){
                break;
            }
            int x = next[0];
            int y = next[1];
            if (validate(x, y)){
                if (block[x][y] == 0){
                    block[x][y] = 2;
                    res++;
                    tmp = pos;
                    pos = next;
                    next = tmp;
                    turns = 0;
                    donext();
                }else if (block[x][y] == 1){
                    index++;
                    turns++;
                    donext();
                }else {
                    break;
                }
            }else {
                index++;
                turns++;
                donext();
            }
        }
        return res;
    }
    int m,n;
    int[] tmp;
    int[] turn = new int[]{0, 1, 0, -1};
    int index = 0;
    int[] pos = new int[]{0,0};
    int[] next = new int[2];
    boolean validate(int x, int y){
        return x >= 0 && x <m && y >=0 && y < n;
    }

    void donext(){
        int x = pos[0];
        int y = pos[1];
        next[0] = x + turn[index % 4];
        next[1] = y + turn[(index + 1)%4];
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int block_rows = 0;
        int block_cols = 0;
        block_rows = in.nextInt();
        block_cols = in.nextInt();

        int[][] block = new int[block_rows][block_cols];
        for(int block_i=0; block_i<block_rows; block_i++) {
            for(int block_j=0; block_j<block_cols; block_j++) {
                block[block_i][block_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        res = new Solution().numberOfPatrolBlocks(block);
        System.out.println(String.valueOf(res));

    }
}
