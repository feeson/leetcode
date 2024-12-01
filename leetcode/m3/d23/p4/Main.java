package y24.m3.d23.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {
    static class Node{
        String val;
        int len;
        Node(String val,int len){
            this.val = val;
            this.len = len;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = s[0];
        double weight = s[1];
        String line = reader.readLine();
        String[] split = line.split("()");
        int n = 0;
        List<Node> list = new ArrayList<>();
        int index = 0;
        int val = 0;
        Node node = null;
        while (index < split.length){
            char c = split[index].toCharArray()[0];
            if (c >= 'a' && c <= 'z'){
                node = new Node(String.valueOf(c),0);
            }else if (c =='('){

            }else if (c ==')'){
                node.len = val;
                list.add(node);
            }else {
                val*=10;
                val += Integer.parseInt(String.valueOf(c));
            }
            index++;
        }
        int res = -1;
        while (!list.isEmpty()){
            Set<String> set = new HashSet<>();
            double lenTotal = 0;
            Node nd = null;
            double sup = 0;
            do {
                nd = list.remove(0);
                set.add(nd.val);
                sup = set.size() * (lenTotal + nd.len);
                if (sup >= weight) {
                    int should = (int) Math.ceil(weight / ((double) set.size()) - lenTotal);
                    sup = set.size() * (lenTotal + should);
                    nd.len -= should;
                    list.add(0,nd);
                }
            }while (sup < weight);
            if (res == -1)
                res = 2;
            else
                res++;
        }
    }
}
