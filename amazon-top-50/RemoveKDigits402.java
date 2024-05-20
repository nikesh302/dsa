import java.util.Stack;

public class RemoveKDigits402 {
    public static void main(String[] args) {
        String num = "10200";
        int k = 2;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        StringBuilder sb = new StringBuilder();

        // push to stack till its increasing & pop if lower element is found
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k>0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        // if k > 0 then pop elements from stack
        while (k > 0) {
            st.pop();
            k--;
        }
        
        // add elements from stack to sb
        for(Character ch : st) {
            if(sb.length() == 0 && ch == '0') {
                continue;
            }
            sb.append(ch);
        }

        if(sb.length() == 0) {
            return "0";
        }
        
        return sb.toString();
    }
}
