class Solution {
    public boolean isMatch(String text, String pattern) {
        // Get the lengths of the text and pattern
        int n = text.length();
        int m = pattern.length();
        
        // Initialize a dynamic programming array to store the results of subproblems
        // dp[i][j][0] indicates if dp[i][j][1] has been calculated
        boolean[][][] dp = new boolean[n + 2][m + 2][2];
        
        // Call the helper function to perform the matching
        return helper(0, 0, n, m, text, pattern, dp);
    }

    // Helper function to perform matching recursively with memoization
    static boolean helper(int i, int j, int n, int m, String text, String pattern, boolean[][][] dp) {
        // Base case: If both text and pattern are exhausted, return true
        if (i >= n && j >= m) {
            return true;
        }
        
        // Base case: If pattern is exhausted but text is not, return false
        if (j >= m) {
            return false;
        }

        // If the result for this state has been calculated before, return it
        if (dp[i][j][0]) {
            return dp[i][j][1];
        }
        
        // Mark that the result for this state is being calculated
        dp[i][j][0] = true;

        // If the next character in the pattern is '*', handle it
        if (j + 1 < m && pattern.charAt(j + 1) == '*') {
            // Try matching zero occurrences of the preceding character
            boolean matchZero = helper(i, j + 2, n, m, text, pattern, dp);
            
            // Try matching one or more occurrences of the preceding character
            boolean matchOne = false;
            if (i < n && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
                matchOne = helper(i + 1, j, n, m, text, pattern, dp);
            } 

            // Return true if either matching zero or one or more occurrences is successful
            return dp[i][j][1] = matchZero || matchOne;
        }

        // If the next character in the pattern is not '*', check if the characters match
        if (i < n && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
            return dp[i][j][1] = helper(i + 1, j + 1, n, m, text, pattern, dp);
        }
        
        // If characters don't match, return false
        return dp[i][j][1] = false;
    }
}

// Time Complexity Analysis:
// The time complexity of this solution depends on the lengths of the text and pattern.
// Let n be the length of the text and m be the length of the pattern.
// The worst-case time complexity is O(n * m), where we iterate through each character of the text and pattern.

// Space Complexity Analysis:
// The space complexity of this solution is O(n * m), where n and m are the lengths of the text and pattern, respectively.
// We use additional space to store the dynamic programming array, which has dimensions (n + 2) * (m + 2) * 2.
