package y24.m3.d18.p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int groupTotal = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        for (int group = 0;group < groupTotal;++group){
            int n  =Integer.parseInt(reader.readLine());
            int[][] nums = new int[n][2];
            char[] charArray = reader.readLine().toCharArray();
            reader.readLine();
            for (int i =0;i<n;++i){
                nums[i][0] = charArray[i] - '0';
                nums[i][1] = i + 1;
            }
            Arrays.sort(nums,(a1,a2)->{
                if (a1[0] != a2[0])
                    return a1[0] - a2[0];
                else
                    return a1[1]-a2[1];
            });
            int ls1 = 0,le1=0,s0=0,e0=0,rs1=0,re1=0;
            for (int i =0;i<n;++i){
                if (nums[i][0] == 1){
                    e0 = i;
                    rs1 = i;
                    break;
                }
            }
            if (e0 == 0){
                e0 = n;
                rs1 = n;
            }
            for (int i =n -1;i>=0;i--){
                if (nums[i][0] !=2){
                    re1 = i + 1;
                    break;
                }
            }
            char[] charArray1 = reader.readLine().toCharArray();
            for (char c:charArray1){
                if (c =='M'){
                    if (ls1 < le1){
                        if (rs1 < re1 && nums[rs1][1] < nums[ls1][1]){
                            output.append(nums[rs1][1]).append('\n');
                            rs1++;
                        }else {
                            output.append(nums[ls1][1]).append('\n');
                            ls1++;
                        }
                    }else {
                        if (rs1 < re1){
                            output.append(nums[rs1][1]).append('\n');
                            rs1++;
                        }else {
                            output.append(nums[s0][1]).append('\n');
                            s0++;
                            le1++;
                        }
                    }
                }else {
                    if (s0 < e0){
                        output.append(nums[s0][1]).append('\n');
                        s0++;
                        le1++;
                    }else {
                        if (ls1 < le1){
                            if (rs1 < re1 && nums[rs1][1] < nums[ls1][1]){
                                output.append(nums[rs1][1]).append('\n');
                                rs1++;
                            }else {
                                output.append(nums[ls1][1]).append('\n');
                                ls1++;
                            }
                        }else {
                            if (rs1 < re1){
                                output.append(nums[rs1][1]).append('\n');
                                rs1++;
                            }else {
                                // EXCEPTION
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
        System.out.print(output.toString());
    }
}
