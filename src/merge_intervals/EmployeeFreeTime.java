package merge_intervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}



class EmployeeFreeTime {


    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // TODO: Write your code here
        List<Interval> ans = new ArrayList<>();
        List<Interval> merge_intervals = new ArrayList<>();
        for(List<Interval> list : schedule){
            for(int i = 0; i < list.size();i++){
                result.add(list.get(i));
            }
        }
        Collections.sort(result ,(n1,n2)->n1.start-n2.start);
        Iterator<Interval> itrresult = result.iterator();
        Interval first = itrresult.next();
        int start = first.start;
        int end = first.end;
        while(itrresult.hasNext()){
            Interval current = itrresult.next();
            //overlap
            if(current.start <= end){
                end = Math.max(end,current.end);
            }else{ //no-overlap
                merge_intervals.add(new Interval(start,end));
                start = current.start;
                end = current.end;
            }
            merge_intervals.add(new Interval(start,end));
        }
        //[1,4] [6,8] [9,12]
        Iterator<Interval> itrans = merge_intervals.iterator();
        first = itrans.next();
        start = first.start;
        end = first.end;
        while(itrans.hasNext()){
            Interval current = itrans.next();
            if(current.start>end){
                ans.add(new Interval(end,current.start));
            }
            start = current.start;
            end = current.end;
        }
        return ans;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}

/**

 Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 Output: [3,5]
 Explanation: Both the employees are free between [3,5].

 Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 Output: [4,6], [8,9]
 Explanation: All employees are free between [4,6] and [8,9].

 [1,4] [6,8] [9,12]

 1.make a new list for working time sort by start time
 2.merge the working time
 start time:a.start
 end time: Math.max(a.end,b.end)
 3.then find the intervals between these free time





 */




