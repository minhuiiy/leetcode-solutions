class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int fasthest = 0;
        for(int i = 0; i <= fasthest && i < n; i++) {
            fasthest = Math.max(fasthest, i + nums[i]);
            if(fasthest >= n - 1) return true;
        }
        return n == 1;
    }
}