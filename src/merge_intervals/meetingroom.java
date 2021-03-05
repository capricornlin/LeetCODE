package merge_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingroom {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b)->b[1]-a[1]);
        int max = Integer.MIN_VALUE;
        for(int[] interval : intervals){
            while(minheap.size()!=0 && interval[0]>=minheap.peek()[1]){
                minheap.poll();
            }
            minheap.offer(interval);
            max = Math.max(max,minheap.size());
        }
        return max;
    }

}

