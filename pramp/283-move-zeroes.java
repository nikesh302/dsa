/**
 * Class to implement a solution for moving zeroes to the end of an integer array.
 * Time Complexity: O(n), where n is the length of the input array nums.
 *                  The algorithm traverses the array once.
 * Space Complexity: O(1)
 *                   The algorithm uses only a constant amount of extra space.
 */
class Solution {
    /**
     * Moves all zeroes in the given array to the end while maintaining the relative order of non-zero elements.
     *
     * @param nums The array of integers.
     */
    public void moveZeroes(int[] nums) {
        // Length of the array
        int n = nums.length;
        // Initialize pointers for zero and non-zero elements
        int zeroInd = 0;
        int numInd = 0;

        // Iterate until either pointer reaches the end of the array
        while (zeroInd < n && numInd < n) {
            // Move zeroInd pointer to the next non-zero element
            while (zeroInd < n && nums[zeroInd] != 0) {
                zeroInd++;
            }

            // Move numInd pointer to the next zero element after zeroInd
            numInd = zeroInd + 1;
            while (numInd < n && nums[numInd] == 0) {
                numInd++;
            }

            // If both pointers are within bounds, swap the elements at zeroInd and numInd
            if (zeroInd < n && numInd < n) {
                int temp = nums[zeroInd];
                nums[zeroInd] = nums[numInd];
                nums[numInd] = temp;
            }
        }
    }
}
