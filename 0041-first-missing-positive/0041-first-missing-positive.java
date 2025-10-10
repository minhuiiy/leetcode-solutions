class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        }

        for(int x : nums) {
            int v = Math.abs(x);
            if(v >= 1 && v <= n) {
                int idx = v - 1;
                if(nums[idx] > 0) nums[idx] = -nums[idx];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}