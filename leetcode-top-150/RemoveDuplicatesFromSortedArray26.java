public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

        System.out.println();
        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 0;
        int curElement = nums[0];

        while(right < n) {
            while(right < n && nums[right] == curElement) {
                right++;
            }

            if(right < n) {
                nums[left++] = nums[right];
                curElement = nums[right];
            }
        }

        return left;
    }
}
