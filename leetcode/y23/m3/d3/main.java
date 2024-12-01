package y23.m3.d3;

public class main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] arr=new String[]{"gta","gta(1)","gta","avalon"};
        String[] res=new String[4];
        res=solution.getFolderNames(arr);
        for (int i=0;i<4;++i){
            System.out.println(res[i]);
        }
    }
}
