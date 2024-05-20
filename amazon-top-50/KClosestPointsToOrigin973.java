import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {
    public static void main(String[] args) {
        int[][] points = {{3,3}, {1,1}, {2,2}};
        int k = 2;
        int[][] ans = kClosest(points, k);

        for(int[] arr : ans) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int dist1 = a[0]*a[0] + a[1]*a[1];
            int dist2 = b[0]*b[0] + b[1]*b[1];

            return dist2 - dist1;
        });

        for(int[] pt : points) {
            if(k-- > 0) {
                maxHeap.offer(pt);
            }
            else {
                int newDist = pt[0]*pt[0] + pt[1]*pt[1];
                int[] top = maxHeap.peek();
                int peekDist = top[0]*top[0] + top[1]*top[1];

                if(newDist < peekDist) {
                    maxHeap.poll();
                    maxHeap.offer(pt);
                }
            }
        }

        int[][] ans = new int[maxHeap.size()][];

        for(int i=0; i< ans.length; i++) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}
