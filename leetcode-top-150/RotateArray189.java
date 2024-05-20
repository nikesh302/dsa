public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 1;
        rotate(nums, k);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = (n - k%n);
        helper(0, k-1, nums);
        helper(k, n-1, nums);
        helper(0, n-1, nums);
    }

    public static void helper(int start, int end, int[] nums) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

