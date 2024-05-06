

class Solution {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        
        for(int i : nums1) {
            System.out.print(i + " ");
        }
    }


    /**
     * *Merge two sorted integer arrays into one sorted array.
     * 
     * @param nums1 The first sorted integer array with extra space at the end.
     * @param m The number of elements in nums1 (excluding extra space).
     * @param nums2 The second sorted integer array.
     * @param n The number of elements in nums2.
     * 
     * !Time Complexity: O(m + n)
     *   - Where m is the number of elements in nums1 and n is the number of elements in nums2.
     *   - The algorithm iterates through both arrays once.
     * 
     * !Space Complexity: O(1)
     *   - The algorithm operates in-place, modifying the nums1 array.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for nums1 and nums2, and index for merged array.
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;

        // Merge arrays until one of them is fully processed.
        while (p1 >= 0 && p2 >= 0) {
            // Compare elements from both arrays and add the greater one to nums1.
            if (nums2[p2] >= nums1[p1]) {
                nums1[index--] = nums2[p2--];
            } else {
                nums1[index--] = nums1[p1--];
            }
        }

        // Add remaining elements from nums2 to nums1 if any.
        while (p2 >= 0) {
            nums1[index--] = nums2[p2--];
        }
    }

}