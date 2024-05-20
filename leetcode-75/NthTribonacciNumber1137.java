public class NthTribonacciNumber1137 {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        if(n < 2) return n;
        if(n == 2) return 1;

        int t0 = 0, t1 = 1, t2 = 1;

        for(int i=3; i<=n; i++) {
            int tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }

        return t2;
    }
}
