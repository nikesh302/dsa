import java.util.Stack;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 72, 71};
        int[] answer = dailyTemperatures(temperatures);

        for(int num : answer) {
            System.out.print(num + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int index = st.pop();
                answer[index] = i - index;
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            answer[st.pop()] = 0;
        }

        return answer;
    }
}
