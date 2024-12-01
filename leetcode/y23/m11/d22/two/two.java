package y23.m11.d22.two;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        int[]res = new int[total];
        for (int i = 0;i<total;++i){
            int len = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int l =0;
            while (l<len&&!s1[l].equals("1"))
                l++;
            int r =len-1;
            while (r>=0&&!s1[r].equals("1"))
                r--;
            if (l == r||l>=len||r<0)
                res[i]=0;
            int cnt = 0;
            for (int j = l;j<=r;++j){
                if (s1[j].equals("0"))
                    cnt++;
            }
            res[i] =cnt;
        }
        for (int val:res)
            System.out.println(val);
    }
}
