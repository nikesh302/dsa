// Problem url : https://www.geeksforgeeks.org/problems/largest-divisible-subset--170643/1

import java.util.*;

class Solution {
    // Function to find the largest subset of integers from the given array
    // such that each element in the subset is divisible by its preceding elements.
    public static List<Integer> findLargestSubset(int n, int[] arr) {
        Arrays.sort(arr); // Sorting the array for easier computation
        int[] dp = new int[n]; // Dynamic programming table to store the length of largest subsets
        int[] prevIndices = new int[n]; // Array to store previous indices for reconstructing the subset
        int maxLen = 1; // Initialize maximum subset length
        int maxLenIndex = 0; // Initialize the index of the maximum subset length
        List<Integer> largestSubset = new ArrayList<>(); // Initialize list to store the largest subset

        // Initializing dp and prevIndices arrays
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Initialize each element of dp to 1
            prevIndices[i] = i; // Each element is initially its own previous index
        }

        // Dynamic programming approach to find the length of largest subsets
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) { // If arr[i] is divisible by arr[j]
                    if (1 + dp[j] > dp[i]) { // If extending subset including arr[i] is longer
                        dp[i] = 1 + dp[j]; // Update length of subset ending at arr[i]
                        prevIndices[i] = j; // Update previous index of arr[i]
                    }
                }
            }
            // Update maximum subset length and index if needed
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxLenIndex = i;
            }
        }

        // Reconstruct the largest subset using prevIndices starting from maxLenIndex
        int iterator = maxLenIndex;
        while (prevIndices[iterator] != iterator) {
            largestSubset.add(arr[iterator]); // Add current element to the subset
            iterator = prevIndices[iterator]; // Move to previous element
        }
        largestSubset.add(arr[iterator]); // Add the last element
        Collections.reverse(largestSubset); // Reverse the list to maintain order

        return largestSubset;
    }

    // Time Complexity Analysis: O(n^2)
    // The time complexity of this method is O(n^2), where n is the size of the input array.
    // This is because we use nested loops to iterate through all pairs of elements in the array.

    // Space Complexity Analysis: O(n)
    // The space complexity is O(n) because we use additional arrays of size n (dp and prevIndices)
    // to store dynamic programming information and previous indices.
}

