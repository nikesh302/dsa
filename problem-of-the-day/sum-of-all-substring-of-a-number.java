class Solution {
    // Function to find the sum of all possible substrings of the given string.
    public static long sumSubstrings(String s) {
        // Using modulo to avoid integer overflow
        int mod = (int)(1e9 + 7);
        int n = s.length(); // Length of the string
        long[] dp = new long[n]; // Array to store the sum of substrings ending at each index
        dp[0] = Character.getNumericValue(s.charAt(0)); // Initialize dp array with the first character
        long totalSum = dp[0]; // Initialize total sum with the first character's value

        for (int i = 1; i < n; i++) {
            // Formula to calculate the sum of substrings ending at index i
            // The sum of substrings ending at i is (i+1) * current digit + 10 * sum of substrings ending at (i-1)
            dp[i] = ((i + 1) * Character.getNumericValue(s.charAt(i)) + 10 * dp[i - 1]) % mod;
            // Add the sum of substrings ending at index i to the total sum
            totalSum = (totalSum + dp[i]) % mod;
        }

        return totalSum; // Return the total sum of all possible substrings
    }
}

// Time Complexity Analysis: O(N)
// The time complexity of this solution is O(n), where n is the length of the string s. 
// This is because we iterate through each character of the string once to calculate the sum of substrings.

// Space Complexity Analysis: O(N)
// The space complexity of this solution is O(n), where n is the length of the string s. 
// This is because we use an additional array dp of length n to store the sum of substrings ending at each index.
