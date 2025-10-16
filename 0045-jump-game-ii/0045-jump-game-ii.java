class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;

        int steps = 0;
        int end = 0;
        int farthest = 0;

        for(int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(i == end) {
                steps++;
                end = farthest;
                if(end >= n - 1) break;
            }
        }
        return steps;
    }
}