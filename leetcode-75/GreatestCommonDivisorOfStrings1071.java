import java.util.HashSet;
import java.util.Set;

public class GreatestCommonDivisorOfStrings1071 {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABCABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<gcd; i++) {
            ans.append(str1.charAt(i));
        }

        return ans.toString();
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd (b, a%b);
    }
}
