package y24.m3.d23.p9;

public class Main {
    public static void main(String[] args) {
        int n = 100000;
        double p = 0.001;
        int m = estimateBloomFilterSize(n, p);
        System.out.println(m);
        System.out.println(m/8/1024);
    }
    public static int estimateBloomFilterSize(int n, double p) {
        return (int) Math.ceil(-(n * Math.log(p)) / (Math.log(2) * Math.log(2)));
    }


}
