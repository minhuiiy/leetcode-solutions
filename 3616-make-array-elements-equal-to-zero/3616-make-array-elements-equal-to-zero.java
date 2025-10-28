class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        long S = 0;
        for(int x : nums) {
            S += x;
        }

        long L = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                Long R = S - L;
                if(L == R) {
                    ans += 2;
                } else if (Math.abs(L - R) == 1) {
                    ans += 1;
                }
            }

            L += nums[i];
        }
        return ans;
    }
}