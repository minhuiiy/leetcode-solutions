class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long occupied = Long.MIN_VALUE;
        int ans = 0;

        for(int x : nums) {
            long L = (long) x - k;
            long R = (long) x + k;
            if(occupied < R) {
                occupied = Math.max(occupied + 1, L);
                ans++;
            }
        }

        return ans;
        
    }
}