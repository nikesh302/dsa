class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * *Remove all occurrences of a specified value from an integer array.
     * 
     * @param nums The integer array.
     * @param val The value to be removed.
     * @return The number of remaining elements after removal.
     * 
     * !Time Complexity: O(n)
     *   - Where n is the length of the input array nums.
     *   - The algorithm iterates through the array once.
     * 
     * !Space Complexity: O(1)
     *   - The algorithm operates in-place, modifying the input array nums.
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cnt = 0;
        int valInd = 0;
        int nonValInd = 0;

        while(valInd < n && nonValInd < n) {
            while(valInd < n && nums[valInd] != val) {
                valInd++;
            }
            nonValInd = valInd+1;
            while(nonValInd < n && nums[nonValInd] == val) {
                nonValInd++;
            }

            if(valInd < n && nonValInd < n) {
                int temp = nums[valInd];
                nums[valInd] = nums[nonValInd];
                nums[nonValInd] = temp;
            }
        }

        int index = 0;
        while(index < n && nums[index] != val) {
            cnt++;
            index++;
        }

        return cnt;
    }
}