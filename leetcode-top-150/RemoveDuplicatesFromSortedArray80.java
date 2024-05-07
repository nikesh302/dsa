public class RemoveDuplicatesFromSortedArray80 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(removeDuplicates(nums));

        System.out.println();
        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int curElement = nums[0];
        int curElementCnt = 0;

        while(right < n) {
            while (right < n && nums[right] == curElement) {
                curElementCnt++;
                right++;
            }

            if(right < n) {
                for(int i=0; i<Math.min(curElementCnt,2); i++) {
                    nums[left++] = curElement;
                }
                curElement = nums[right];
                curElementCnt = 0;
            }
        }

        for(int i=0; i<Math.min(curElementCnt,2); i++) {
            nums[left++] = curElement;
        }

        return left;
    }
}
