package y23.m9.d24;

class Solutionp2 {
    public String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        int len=charArray.length;
        int cnt1=0;
        for (int i=0;i<len;++i){
            if (charArray[i]=='1')
                cnt1++;
        }
//        String res="1".repeat(cnt1-1)+"0".repeat(len-cnt1)+"1";
        return null;
    }
}