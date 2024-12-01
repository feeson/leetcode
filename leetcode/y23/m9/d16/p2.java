package y23.m9.d16;

class Solutionp2 {
    public String replaceSpace(String s) {
        String p20="%20";
        char[] charArray = s.toCharArray();
        int len=charArray.length;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<len;++i){
            if (charArray[i]==' ')
                sb.append(p20);
            else
                sb.append(charArray[i]);
        }
        return sb.toString();
    }
}