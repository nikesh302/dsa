public class BestTimeToBuyAndSellStockWithTransactionFee714 {
    public static void main(String[] args) {
        int[] prices = {1,5};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        return recursion(0, 1, prices, fee, dp);
    }

    public static int recursion(int index, int canBuy, int[] prices, int fee, int[][] dp) {
        if(index == prices.length) {
            return 0;
        }

        if(dp[index][canBuy] != 0) {
            return dp[index][canBuy];
        }

        // canBuy
        if(canBuy == 1) {
            // buy today
            int option1 = -prices[index] + recursion(index+1, 0, prices, fee, dp);
            // not buy today
            int option2 = recursion(index+1, 1, prices, fee, dp);
            return dp[index][canBuy] = Math.max(option1, option2);
        }

        // canSell
        else {
            // sell today
            int option1 = prices[index] - fee + recursion(index+1, 1, prices, fee, dp);
            // not sell today
            int option2 = recursion(index+1, canBuy, prices, fee, dp);
            return dp[index][canBuy] = Math.max(option1, option2);
        }
    }
}
