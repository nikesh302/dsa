import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public static void main(String[] args) {
        int k = 4;
        int n = 1;
        List<List<Integer>> ans = combinationSum3(k, n);
        
        for(List<Integer> list : ans) {
            for(int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    public static void helper(int num, int k, int sum, List<Integer> list, List<List<Integer>> ans) {
        if(sum == 0 && k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(num> 9 || sum < 0 || k < 0) {
            return;
        }

        // take current num
        list.add(num);
        helper(num+1, k-1, sum-num, list, ans);
        // remove taken element
        list.remove(list.size()-1);

        // not take current num
        helper(num+1, k, sum, list, ans);
    }
}
