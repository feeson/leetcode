package y24.huawei.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int len = n;
        int[][] matrix = new int[len][len];
        while (n > 0){
            matrix[len - n] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n--;
        }
        int[] exposed = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 枚举
        int ans = 1_000_000_000;
        int index = -1;
        for (int closed:exposed){
            int[] effected = new int[len];
            for (int from:exposed){
                if (from == closed)
                    continue;
                effected[from] = 10;
                LinkedList<int[]> list = new LinkedList<>();
                for (int i = 0;i < len; ++i){
                    if (matrix[from][i] != 0 && matrix[from][i] > effected[i]){
                        // 有更高权限访问
                        list.add(new int[]{i, matrix[from][i]});
                    }
                }
                while (!list.isEmpty()){
                    int[] first = list.removeFirst();
                    from = first[0];
                    int power = first[1];
                    if (power < effected[from]){
                        //过期了
                        continue;
                    }
                    effected[from] = power;
                    for (int i = 0;i < len; ++i){
                        if (power >= matrix[from][i] && matrix[from][i] > effected[i]){
                            // 可达且可刷新
                            list.add(new int[]{i, matrix[from][i]});
                        }
                    }
                }
            }
            int effec = 0;
            for (int ef:effected){
                if (ef != 0)
                    effec++;
            }
            if (effec < ans){
                ans = effec;
                index = closed;
            }
        }
        System.out.println(index);
    }
}
