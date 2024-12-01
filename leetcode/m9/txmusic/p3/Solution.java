package y24.m9.txmusic.p3;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回一个整数，表示答案
     * @param a int整型ArrayList<ArrayList<>>
     * @param val int整型
     * @return int整型
     */
    public int matrixCount (String[] a, int myval) {
        // write code here
        len = a.length;
        int NOlen = len * len;
        int[][][] mem = new int[NOlen][len + 1][3];
        char[][] mat = new char[len][len];
        for (int i = 0; i < len; i++) {
            mat[i] = a[i].toCharArray();
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                mem[getNo(i, j)][1][getIndex(mat[i][j])]++;
                if (getmin(mem, getNo(i, j), 1) >= myval){
                    res++;
                }
            }
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                add(mem, getNo(i ,j), getNo(i, j), 2, 1, true);
                add(mem, getNo(i ,j), getNo(i, j + 1), 2, 1, true);
                add(mem, getNo(i ,j), getNo(i + 1, j), 2, 1, true);
                add(mem, getNo(i ,j), getNo( i + 1, j + 1), 2, 1, true);
                if (getmin(mem, getNo(i, j), 2) >= myval){
                    res++;
                }
            }
        }
        for(int k = 3; k <= len; ++k){
            for (int i = 0; i + k <= len; i++) {
                for (int j = 0; j + k <= len; j++) {
                    add(mem, getNo(i , j), getNo(i + 1, j), k, k-1, true);
                    add(mem, getNo(i , j), getNo(i, j + 1), k, k-1, true);
                    add(mem, getNo(i , j), getNo(i + 1, j + 1), k, k-2, false);
                    add(mem, getNo(i , j), getNo(i, j), k, 1, true);
                    add(mem, getNo(i , j), getNo(i + k - 1, j + k - 1), k, 1, true);
                    if (getmin(mem, getNo(i, j), k)>= myval)
                        res++;
                }
            }
        }
        return res;
    }
    int len;
    void add(int[][][] mem, int NO1, int NO2, int l1, int l2, boolean add){
        if (add){
            for (int i = 0; i < 3; i++) {
                mem[NO1][l1][i] += mem[NO2][l2][i];
            }
        }else {
            for (int i = 0; i < 3; i++) {
                mem[NO1][l1][i] -= mem[NO2][l2][i];
            }
        }

    }
    int getIndex(char c){
        if (c == 'r')
            return 0;
        else if (c == 'e')
            return 1;
        return 2;
    }
    int getmin(int[][][] mem, int NO, int l){
        return Math.min(mem[NO][l][0], Math.min(mem[NO][l][1], mem[NO][l][2]));
    }
    int getNo(int i, int j){
        return i * len + j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = new String[]{"red", "red", "red"};
        solution.matrixCount(arr, 2);
    }
}