import java.util.Stack;

public class OnlineStockSpan901 {
    static Stack<int[]> st = new Stack<>();
    public static void main(String[] args) {
        System.out.println(next(100));
        System.out.println(next(80));
        System.out.println(next(60));
        System.out.println(next(70));
        System.out.println(next(60));
        System.out.println(next(75));
        System.out.println(next(85));
    }
    
    public static int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek()[0] <= price) {
            int[] top = st.pop();
            span += top[1];
        }

        st.push(new int[] {price, span});

        return span;
    }
}
