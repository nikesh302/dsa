class Solution {
    
    /**
     * Finds the nth root of a given number using binary search.
     * 
     * @param n The root value
     * @param m The number for which the nth root is to be found
     * @return  The nth root of the given number if found, -1 otherwise
     */
    public int NthRoot(int n, int m) {
        // Time Complexity: O(log(m)), where m is the given number.
        //                   This is due to the binary search approach.
        // Space Complexity: O(1), constant space is used.
        
        int left = 1; // Initialize the left pointer to 1
        int right = m; // Initialize the right pointer to the given number
        
        // Perform binary search until left pointer is less than or equal to the right pointer
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle value
            
            int nthPow = (int) Math.pow(mid, n); // Calculate the nth power of the middle value
            
            // If nth power equals the given number, return the middle value
            if (nthPow == m) {
                return mid;
            }
            
            // If nth power is less than the given number, move the left pointer to mid + 1
            if (nthPow < m) {
                left = mid + 1;
            } 
            // If nth power is greater than the given number, move the right pointer to mid - 1
            else {
                right = mid - 1;
            }
        }
        
        // If the nth root is not found, return -1
        return -1;
    }
}
