public class MergeStringsAlternately1768 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        int n1 = word1.length(), n2 = word2.length();
        boolean word1Turn = true;

        while(p1 < n1 && p2 < n2) {
            if(word1Turn) {
                sb.append(word1.charAt(p1++));
            }
            else {
                sb.append(word2.charAt(p2++));
            }
            word1Turn = !word1Turn;
        }

        while(p1 < n1) {
            sb.append(word1.charAt(p1++));
        }

        while(p2 < n2) {
            sb.append(word2.charAt(p2++));
        }

        return sb.toString();
    }
}
