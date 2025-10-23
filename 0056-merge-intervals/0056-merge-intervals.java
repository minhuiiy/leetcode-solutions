class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0], ne = intervals[i][1];
            if(ns <= e) {
                e = Math.max(e, ne);
            } else {
                res.add(new int[]{s, e});
                s = ns; e = ne;
            }
        }

        res.add(new int[]{s, e});
        return res.toArray(new int[res.size()][]);
    }
}