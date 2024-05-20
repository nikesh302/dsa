public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int me = nums[0];
        int cnt = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == me) {
                cnt++;
            }
            else {
                cnt--;
            }
            if(cnt == 0) {
                me = nums[i];
                cnt = 1;
            }
        }

        return me;
    }
}
