/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> arr = new ArrayList<>();
        
        int n = schedule.size();
        for(int i=0; i<n; i++){
            int m = schedule.get(i).size();
            for(int j=0; j<m; j++){
                arr.add(schedule.get(i).get(j));
            }
        }
        Collections.sort(arr, (a,b) -> a.start != b.start ? a.start - b.start: b.end - a.end);
        
        List<Interval> ans = new ArrayList<>();
        int prev_end = -1;
        for(int i=0; i<arr.size(); i++){
            //System.out.println(arr.get(i).start+" "+arr.get(i).end);
            
            Interval event = arr.get(i);
            if (prev_end != -1 && event.start > prev_end){
                ans.add(new Interval(prev_end, event.start));
            }
            prev_end = Math.max(prev_end,event.end);
        }

        return ans;
    }
}
