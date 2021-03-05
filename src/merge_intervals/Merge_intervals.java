package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Merge_intervals{
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);

    }


}

//class Solution {
//    public int[][] merge(int[][] intervals) {
//        int row = intervals.length;
//        int col = intervals[0].length;
//        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//        List<List<Integer>> merge_list = new ArrayList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        for(int i = 0;i < row;i++){
//            List<Integer> current = new ArrayList<>();
//            for(int j = 0; j < col;j++){
//                current.add(intervals[i][j]);
//            }
//            list.add(current);
//        }
//        Iterator<List<Integer>> itr = list.iterator();
//        List<Integer> first = itr.next();
//        int start = first.get(0);
//        int end = first.get(1);
//        while(itr.hasNext()){
//            List<Integer> current = itr.next();
//            if(current.get(0) <= end){
//                end = Math.max(end,current.get(1));
//            }else{
//                List<Integer> l = new ArrayList<>();
//                l.add(start);
//                l.add(end);
//                merge_list.add(l);
//                start = current.get(0);
//                end = current.get(1);
//            }
//
//        }
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(start);
//        l2.add(end);
//        merge_list.add(l2);
//        int[][] ans = new int[merge_list.size()][2];
//        int i =0;
//        for(List<Integer> current_list:merge_list){
//            ans[i][0] = current_list.get(0);
//            ans[i][1] = current_list.get(1);
//            i++;
//        }
//        return ans;
//    }
//}



