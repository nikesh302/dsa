import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DominoAndTrominoTiling790 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(numTilings(n));
    }

    public static int numTilings(int n) {
        if(n < 4) {
            switch(n) {
                case 1 : return 1;
                case 2 : return 2;
                case 3 : return 5;
            }
        }

        int MOD = (int)(1e9+7);
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for(int i=4; i<=n; i++) {
            dp[i] = (2 * dp[i-1]%MOD + dp[i-3]%MOD) % MOD;
        }

        return dp[n];
    }
}

/**
 *      dp[n] = dp[n-1] + dp[n-2] + 2 * {dp[n-3] + dp[n-4] + ... + dp[0]}
 *      dp[n] = dp[n-1] + dp[n-2] + dp[n-3] + dp[n-3] + 2 * {dp[n-4] + dp[n-5] + ... + dp[0]}
 *      dp[n] = dp[n-1] + dp[n-3] + dp[n-2] + dp[n-3] + 2 * {dp[n-4] + dp[n-5] + ... + dp[0]}
 *      dp[n] = dp[n-1] + dp[n-3] + dp[n-1]
 *      dp[n] = 2 * dp[n-1] + dp[n-3]
 *      
 */
