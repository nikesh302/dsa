public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                // char at i match with char at j
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                // chars don't match
                else {
                    int option1 = dp[i-1][j];
                    int option2 = dp[i][j-1];

                    dp[i][j] = Math.max(option1, option2);
                }
                
            }
        }

        return dp[m][n];
    }

    public static int recursion(int p1, int p2, String text1, String text2, int[][] dp) {
        // base case
        if(p1 < 0 || p2 < 0) {
            return 0;
        }

        if(dp[p1][p2] != 0) {
            return dp[p1][p2];
        }

        // char at p1 match with char at p2
        if(text1.charAt(p1) == text2.charAt(p2)) {
            return dp[p1][p2] = 1 + recursion(p1-1, p2-1, text1, text2, dp);
        }

        // chars don't match
        int option1 = recursion(p1-1, p2, text1, text2, dp);
        int option2 = recursion(p1, p2-1, text1, text2, dp);

        return dp[p1][p2] = Math.max(option1, option2);
    }
}
