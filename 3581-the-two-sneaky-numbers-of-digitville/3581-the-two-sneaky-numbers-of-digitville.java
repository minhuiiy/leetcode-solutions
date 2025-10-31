class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        final int KMAX = 100;
        int[] cnt = new int[KMAX + 1];
        int[] ans = new int[2];
        int idx = 0;

        for(int x : nums) {
            if(++cnt[x] == 2) {
                ans[idx++] = x;
                if(idx == 2) break;
            }
        }
        return ans;
    }
}