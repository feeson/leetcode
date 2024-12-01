package y22.m09.d29.p1;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 */

/*
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        if (s1.length()==0)
            return true;
        for (int i=0;i < s1.length();++i){
            String head=s1.substring(0,i);
            String rear=s1.substring(i,s1.length());
            head=rear.concat(head);
            if (head.equals(s2))
                return true;
        }
        return false;
    }
}
*/
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length()==s2.length()&&(s1+s1).contains(s2);
    }
}
