// Problem url : https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

//-------------- Approach 1 : Recursion + Memoization --------------//

import java.util.Arrays;

class Solution {
    // Function to find the length of the longest common subsequence in two strings.
    static int longestCommonSubsequence(int x, int y, String s1, String s2) {
        // Initialize variables and dynamic programming table
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m]; // dp[i][j] stores the length of the LCS of s1[0...i] and s2[0...j]
        
        // Fill the DP table with initial values
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        // Call helper function to compute the LCS
        return lcsHelper(n - 1, m - 1, s1, s2, dp);
    }
    
    // Helper function to recursively compute the length of the LCS
    static int lcsHelper(int i, int j, String s1, String s2, int[][] dp) {
        // Base case: if any of the strings becomes empty, LCS length is 0
        if (i < 0 || j < 0) {
            return 0;
        }
        
        // If the result is already calculated, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // If the characters match, include them in the LCS
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsHelper(i - 1, j - 1, s1, s2, dp);
        }
        
        // Otherwise, recursively compute the LCS length by considering two possibilities:
        // 1. Exclude the last character of s1
        // 2. Exclude the last character of s2
        int option1 = lcsHelper(i - 1, j, s1, s2, dp);
        int option2 = lcsHelper(i, j - 1, s1, s2, dp);
        
        // Choose the maximum of the two options
        return dp[i][j] = Math.max(option1, option2);
    }
    
    // Time Complexity Analysis:
    // The time complexity of the longestCommonSubsequence method is O(n * m), where n is the length of the first string
    // and m is the length of the second string. This is because we compute the LCS length for each possible pair of
    // characters from the two strings, and there are n * m such pairs.
    // The time complexity of the lcsHelper method is also O(n * m), as it performs memoized recursive calls for each pair
    // of characters, and each pair is visited only once.
    
    // Space Complexity Analysis:
    // The space complexity of the DP table is O(n * m), where n is the length of the first string and m is the length of
    // the second string. This is because we create a 2D array of size n * m to store intermediate results.
}


//-------------- Approach 2 : Iterative --------------//

class Solution {
    // Function to find the length of the longest common subsequence in two strings.
    static int longestCommonSubsequence(int x, int y, String s1, String s2) {
        // Get the lengths of the input strings
        int n = s1.length();
        int m = s2.length();
        
        // Create a 2D array to store the length of the longest common subsequence
        int[][] dp = new int[n + 1][m + 1];
        
        // Fill the dp array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current positions are equal
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Include the current characters in the common subsequence
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // If the characters are not equal, choose the maximum length
                    // of the subsequence from the previous positions
                    int option1 = dp[i - 1][j];
                    int option2 = dp[i][j - 1];
                    dp[i][j] = Math.max(option1, option2);
                }
            }
        }
        
        // The length of the longest common subsequence is stored at the bottom-right
        // corner of the dp array
        return dp[n][m];
    }
}

// Time Complexity Analysis:
// The time complexity of this function is O(n * m), where n is the length of the first string (s1)
// and m is the length of the second string (s2). This is because we fill up an n * m DP array.

// Space Complexity Analysis:
// The space complexity of this function is O(n * m) as well, because we use a DP array of size n * m.


