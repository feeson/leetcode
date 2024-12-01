package y22.m09.d27.p2;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()){
            StringBuilder st=new StringBuilder(s2);
            int index=-1;
            for (int i=0; i < s1.length(); ++i){
                index=st.indexOf(s1.charAt(i)+"");
                if (index==-1){
                    return false;
                }else {
                    st.deleteCharAt(index);
                }
            }
            return true;
        }else{
            return false;
        }
    }
}