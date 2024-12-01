package y24.huawei.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String,String[]> linkedMap = new LinkedHashMap<>();
        while (n > 0){
            String[] strs = reader.readLine().split(",");
            String key = strs[0] + strs[1] + strs[2];
            if (!linkedMap.containsKey(key)) {
                linkedMap.put(key, strs);
            }
            n--;
        }
        // 统计银子
        int nfact = Integer.parseInt(reader.readLine());
        Map<String, Integer> factors = new HashMap<>();
        while (nfact > 0){
            String[] strs = reader.readLine().split(",");
            factors.put(strs[0], Integer.parseInt(strs[1]));
            nfact--;
        }
        TreeMap<String, Integer> clientCost = new TreeMap<>();
        for (String[] val:linkedMap.values()){
            String client = val[1];
            String factor = val[2];
            String time = val[3];
            if(factors.containsKey(factor)){
                int fct = factors.get(factor);
                int cst = clientCost.getOrDefault(client, 0);
                cst += fct * Integer.parseInt(time);
                clientCost.put(client, cst);
            }else {
                if (!clientCost.containsKey(client)){
                    clientCost.put(client,0);
                }
            }
        }
        while (!clientCost.isEmpty()){
            Map.Entry<String, Integer> stringIntegerEntry = clientCost.pollFirstEntry();
            System.out.println(stringIntegerEntry.getKey()+","+stringIntegerEntry.getValue());
        }
    }
}
