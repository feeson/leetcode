package y22.m10.d03.p2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * p[i][j]=p[i+1][j-1]&&s[i]==s[j]
 *
 */
class Solution {
    public String longestPalindrome(String s) {
        int lenth=s.length();
        if (lenth==1)
            return s;
        char charArr[]=s.toCharArray();
        boolean matrix[][]=new boolean[lenth][lenth];
        for (int i=0;i<lenth;++i){
            for (int j=0;j<lenth;++j){
                matrix[i][j]=false;
            }
            matrix[i][i]=true;
        }
        String res="";
        HashMap<Integer, ArrayList<Integer>> hashtable=new HashMap<>();
        for (int Len=2;Len<=lenth;++Len){
            int start=-1;
            if (Len<=3){
                for (int i=0;i < lenth-Len+1;++i){
                    int j=i+Len-1;
                    if (charArr[i]==charArr[j]){
                        if (Len==2){
                            matrix[i][j]=true;
                            start=i;
                        }else {
                            matrix[i][j]=matrix[i+1][j-1];
                            if (matrix[i+1][j-1]){
                                if (!hashtable.containsKey(Len))
                                    hashtable.put(Len,new ArrayList<>());
                                hashtable.get(Len).add(i);
                                start=i;
                            }
                        }
                    }else {
                        matrix[i][j] = false;
                    }
                }
                if (start!=-1){
                    res=s.substring(start,start+Len);
                }
            }else {
                if (hashtable.containsKey(Len-1)|| hashtable.containsKey(Len-2)){
                    ArrayList<Integer> arr=hashtable.get(Len-1);
                    for (int i : arr) {
                        if (i==0)
                            continue;
                        i=i-1;
                        int j=i+Len-1;
                        if(charArr[i]==charArr[j]){
                            matrix[i][j]=matrix[i+1][j-1];
                            if (matrix[i+1][j-1]){
                                if (!hashtable.containsKey(Len))
                                    hashtable.put(Len,new ArrayList<>());
                                hashtable.get(Len).add(i);
                                start=i;
                            }
                        }else {
                            matrix[i][j] = false;
                        }
                    }
                }else {
                    //返回结果
                    break;
                }
            }
            if (start!=-1){
                res=s.substring(start,start+Len);
            }

        }
        if (res.equals(""))
            return s.charAt(0)+"";
        return res;
    }
}