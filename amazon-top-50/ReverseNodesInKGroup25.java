public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        ListNode head = new ListNode(nums[0]);

        ListNode tail = head;
        for(int i=1; i<nums.length; i++) {
            tail.next = new ListNode(nums[i], null);
            tail = tail.next;
        }
        head = reverseKGroup(head, k);

        tail = head;
        while(tail != null) {
            System.out.print(tail.val + " → ");
            tail = tail.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curHead = head;
        ListNode curTail = curHead;
        ListNode dummyAnsHead = new ListNode(-1, null);
        ListNode dummyAnsTail = dummyAnsHead;

        // get head and tail of k nodes
        while(curTail != null) {
            boolean hasK = true;
            for(int i=0; i<k-1; i++) {
                if(curTail.next != null) {
                    curTail = curTail.next;
                }
                else {
                    hasK = false;
                }
            }

            ListNode nextHead = curTail.next;
            curTail.next = null;
            if(hasK) {
                dummyAnsTail.next = reverse(curHead);
            }
            else {
                dummyAnsTail.next = curHead;
            }
            
            while (dummyAnsTail.next != null) {
                dummyAnsTail = dummyAnsTail.next;
            }

            curHead = nextHead;
            curTail = nextHead;
        }

        return dummyAnsHead.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
