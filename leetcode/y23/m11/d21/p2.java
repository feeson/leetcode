package y23.m11.d21;

class Solutionp2 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int l=0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        if (c1[0]!=c2[0]||c2[0]!=c3[0]||c1[0]!=c3[0])
            return -1;
        int len =Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        while (l<len&&c1[l] == c2[l]&&c2[l]==c3[l]&&c1[l]==c3[l])
            l++;
        return s1.length()-l+s2.length()-l+s3.length()-l;
    }
}