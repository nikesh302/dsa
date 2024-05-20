public class UniquePaths62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    continue;
                }

                // move right
                int right = 0;
                if(j+1 < n) {
                    right = dp[i][j+1];
                }

                // move down
                int down = 0;
                if(i+1 < m) {
                    down = dp[i+1][j];
                }

                dp[i][j] = right + down;
            }
        }

        return dp[0][0];
    }

    public static int recursion(int x, int y, int m, int n, int[][] dp) {
        if(x == m-1 && y == n-1) {
            return 1;
        }

        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        // move right
        int right = 0;
        if(y+1 < n) {
            right = recursion(x, y+1, m, n, dp);
        }

        // move down
        int down = 0;
        if(x+1 < m) {
            down = recursion(x+1, y, m, n, dp);
        }

        return dp[x][y] = right + down;
    }
}
