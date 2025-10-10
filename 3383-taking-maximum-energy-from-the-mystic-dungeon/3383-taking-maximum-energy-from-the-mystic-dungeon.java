class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = energy.clone();
        for(int i = n - 1 - k; i >= 0; --i) {
            dp[i] += dp[i + k];
        }
        int ans = Integer.MIN_VALUE;
        for(int x : dp) ans = Math.max(ans, x);
        return ans;
    }
}