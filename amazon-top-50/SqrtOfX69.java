public class SqrtOfX69 {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int left = 1, right = x;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if((long) mid*mid == (long) x) {
                return mid;
            }
            if((long) mid*mid > (long) x) {
                right = mid-1; 
            }
            else {
                left = mid+1;
            }
        }

        return right;
    }
}
