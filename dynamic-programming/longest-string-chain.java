// Problem url : https://www.geeksforgeeks.org/problems/longest-string-chain/1

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // Function to find the length of the longest word chain
    public static int longestWordChain(int numWords, String[] words) {
        // Sorting the words by length to optimize the solution
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        // Initializing an array to store the length of the longest chain ending at each word
        int[] chainLengths = new int[numWords];
        Arrays.fill(chainLengths, 1); // By default, each word forms a chain of length 1
        
        // Initializing a variable to keep track of the maximum chain length found
        int maxLength = 0;
        
        // Iterating through each word
        for (int i = 0; i < numWords; i++) {
            // Iterating through all previous words to check if the current word can form a chain
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[i], words[j])) {
                    // If the current word is a predecessor of the previous word, update the chain length
                    chainLengths[i] = Math.max(chainLengths[i], 1 + chainLengths[j]);
                }
            }
            // Update the maximum chain length found so far
            maxLength = Math.max(maxLength, chainLengths[i]);
        }
        
        // Return the maximum chain length found
        return maxLength;
    }
    
    // Helper function to check if one word is the predecessor of another
    public static boolean isPredecessor(String current, String previous) {
        int currLength = current.length();
        int prevLength = previous.length();
        
        // If the lengths differ by more than 1, they cannot be predecessors
        if (currLength != prevLength + 1) {
            return false;
        }
        
        // Iterating through the characters of both words to check for a one-character difference
        int i = 0, j = 0;
        while (i < currLength) {
            if (j < prevLength && current.charAt(i) == previous.charAt(j)) {
                // If the characters match, move to the next character in both words
                i++;
                j++;
            } else {
                // If the characters don't match, move to the next character in the current word
                i++;
            }
        }
        
        // If we reached the end of both words, and all characters matched except one, they are predecessors
        return i == currLength && j == prevLength;
    }

    // Time Complexity Analysis: O(n^2 * m)
    // The time complexity of this solution is O(n^2 * m), where n is the number of words
    // and m is the average length of the words. This is because for each word, we iterate
    // through all previous words to find predecessors, resulting in an O(n^2) complexity,
    // and for each comparison, we may need to iterate through the characters of the words,
    // which takes O(m) time.
    
    // Space Complexity Analysis: O(n)
    // The space complexity of this solution is O(n), where n is the number of words.
    // This is because we use an array of size n to store the chain lengths for each word.
}
