import java.util.Arrays;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        int[] cost = {0,0,1,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        helper(-1, n, cost, dp);

        return dp[0];
    }

    public static int helper(int step, int n, int[] cost, int[] dp) {
        if(step >= n) {
            return 0;
        }

        if(dp[step+1] != -1) {
            return dp[step+1];
        }

        int option1 = helper(step+1, n, cost, dp);
        int option2 = helper(step+2, n, cost, dp);

        int curCost = 0;
        if(step != -1) {
            curCost = cost[step];
        }

        return dp[step+1] = curCost + Math.min(option1, option2);
    }
}
