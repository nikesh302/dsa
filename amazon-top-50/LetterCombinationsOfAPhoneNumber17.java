import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        String digits = "24538374245383742";
        List<String> ans = letterCombinations(digits);

        // for(String str : ans) {
        //     System.out.println(str);
        // }

        System.out.println(ans.size());
    }

    public static List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        dfs(0, digits, ans, new StringBuilder(), mapping);

        return ans;
    }

    public static void dfs(int index, String digits, List<String> ans, StringBuilder stringBuilder, String[] mapping) {
        if(index == digits.length()) {
            ans.add(stringBuilder.toString());
            return;
        }

        String options = mapping[digits.charAt(index) - '0'];
        for(Character ch : options.toCharArray()) {
            stringBuilder.append(ch);
            dfs(index+1, digits, ans, stringBuilder, mapping);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
