public class SumOfTotalStrengthOfWizards2281 {
    public static void main(String[] args) {
        int[] strength = {1,3,1,2};
        System.out.println(totalStrength(strength));
    }

    public static int totalStrength(int[] strength) {
        int sumOfStreangth = 0;
        int MOD = (int) (1e9+7);

        for(int start = 0; start < strength.length; start++) {
            sumOfStreangth = (sumOfStreangth + helper(strength, start)) % MOD;
        }

        return sumOfStreangth;
    }

    public static int helper(int[] strength, int start) {
        int MOD = (int) (1e9+7);
        int sumOfStreangth = 0;
        int min = strength[start];
        int sum = 0;
        // calculate sum of strengths of subsets starting from index start
        for(int i=start; i< strength.length; i++) {
            min = Math.min(min, strength[i]);
            sum += strength[i];
            sumOfStreangth =(sumOfStreangth + min*sum) % MOD;
        }

        return sumOfStreangth % MOD;
    }
}

/**
 *  *   Not Optimal solution but it works
 *  !   Time Complexity :   O(N^2)
 */