package y22.m10.d05.p1;

import javax.swing.*;
import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        for (int i=0;i< cpdomains.length;++i){
            String str=cpdomains[i];
            int num=Integer.valueOf(str.substring(0,str.indexOf(' ')));
            str="."+str.substring(str.indexOf(' '));
            while (str.contains(".")){
                str=str.substring(str.indexOf('.')+1);
                if (hashMap.containsKey(str)){
                    hashMap.replace(str,num+hashMap.get(str));
                }else {
                    hashMap.put(str,num);
                }
            }
        }
        List<String> list=new ArrayList<>();
        hashMap.forEach((key,value)->{
            list.add(value+" "+key);
        });
        return list;
    }
}