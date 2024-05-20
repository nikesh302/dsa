import java.util.Arrays;

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];

        for(int i=n-1; i>=0; i--) {
            int option1 = nums[i] + dp[i+2];
            int option2 = 0 + dp[i+1];

            dp[i] = Math.max(option1, option2);
        }

        return dp[0];
    }

    public static int recursion(int index, int[] nums, int[] dp) {
        // base case
        if(index >= nums.length) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        // rob the current house
        int option1 = nums[index] + recursion(index+2, nums, dp);

        // do not rob the current house
        int option2 = 0 + recursion(index+1, nums, dp);

        return dp[index] = Math.max(option1, option2);
    }
}
