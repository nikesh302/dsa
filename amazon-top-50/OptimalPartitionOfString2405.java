import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfString2405 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(partitionString(s));
    }
    
    public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int cnt = 0;

        // iterate over each character of string and form max len substring
        for(int i=0; i<n; i++) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }
            else {
                cnt++;
                set.clear();
                set.add(s.charAt(i));
            }
        }
        
        // If there are elements in set then count it as last combination
        if(!set.isEmpty()) {
            cnt++;
        }

        return cnt;
    }
}