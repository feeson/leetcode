package y24.m3.d23.p6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        char[] charArray = str.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int cnt0 = charArray[0] =='0'?1:0;
        for (int i = 1;i <len;++i){
            if (charArray[i] =='0')
                cnt0++;
            if (charArray[i] == charArray[i - 1]){
                int index = list.size() - 1;
                list.add(list.remove(index) + 1);
            }else {
                list.add(1);
            }
        }
        if (list.size() == 1){
            System.out.println(cal(list.get(0)));
            return;
        }
        int cnt1 = len - cnt0;
        int maxSum = 0;
        int lenList = list.size();
        if (cnt0 > cnt1){
            maxSum = cal(cnt0);
            if (charArray[0] != charArray[len - 1]){
                if (charArray[0] == '0')
                    maxSum += cal(list.get(lenList - 1));
                else
                    maxSum += cal(list.get(0));
            }else {
                if (charArray[0] != '0'){
                    maxSum += cal(list.get(lenList - 1));
                    maxSum += cal(list.get(0));
                }
            }
        }else if (cnt1 > cnt0){
            maxSum = cal(cnt1);
            if (charArray[0] != charArray[len - 1]){
                if (charArray[0] == '1')
                    maxSum += cal(list.get(lenList - 1));
                else
                    maxSum += cal(list.get(0));
            }else {
                if (charArray[0] != '1'){
                    maxSum += cal(list.get(lenList - 1));
                    maxSum += cal(list.get(0));
                }
            }
        }else {
            maxSum = cal(cnt0);
            if (charArray[0] != charArray[len - 1]){
                maxSum += cal(Math.max(list.get(0),list.get(lenList - 1)));
            }else {
                maxSum += cal(list.get(0));
                maxSum += cal(list.get(lenList - 1));
            }
        }
        System.out.println(maxSum);
    }
    static int cal(int n){
        return (1 + n)*n/2;
    }
}
