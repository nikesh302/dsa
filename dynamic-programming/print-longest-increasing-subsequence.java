//Problem url : https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        ArrayList<Integer> longestSubsequence = new ArrayList<>(); // Store the longest increasing subsequence
        int[] dp = new int[n]; // Dynamic programming array to store lengths of increasing subsequences ending at each index
        int[] previousIndex = new int[n]; // Array to store the index of the previous element in the longest increasing subsequence
        int maxLength = 1; // Length of the longest increasing subsequence
        int endIndex = 0; // Index of the last element in the longest increasing subsequence
        
        // Initialize dp array and previousIndex array
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Initially, each element forms a subsequence of length 1
            previousIndex[i] = i; // The previous index of an element is itself
        }
        
        // Dynamic programming to find the length of the longest increasing subsequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { // If the current element is greater than the previous element
                    if (dp[i] < dp[j] + 1) { // If adding the current element to the previous subsequence results in a longer subsequence
                        dp[i] = dp[j] + 1; // Update the length of the subsequence
                        previousIndex[i] = j; // Update the previous index of the current element
                    }
                }
            }
            // Update the length and index of the longest increasing subsequence
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }
        
        // Reconstruct the longest increasing subsequence
        int currentIndex = endIndex;
        while (previousIndex[currentIndex] != currentIndex) {
            longestSubsequence.add(arr[currentIndex]);
            currentIndex = previousIndex[currentIndex];
        }
        longestSubsequence.add(arr[currentIndex]); // Add the first element of the longest increasing subsequence
        
        // Reverse the longest increasing subsequence to get the correct order
        Collections.reverse(longestSubsequence);
        
        return longestSubsequence;
    } 
    
    // Time Complexity: O(n^2) - Two nested loops iterating over the array
    // Space Complexity: O(n) - Two additional arrays of size n used for dynamic programming and storing previous indices
}
