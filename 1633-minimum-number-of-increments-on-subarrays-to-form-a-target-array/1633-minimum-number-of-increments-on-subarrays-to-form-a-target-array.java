class Solution {
    public int minNumberOperations(int[] target) {
        int ans = 0, prev = 0;
        for(int x : target) {
            if(x > prev) ans += x - prev;
            prev = x;
        }
        return ans;
    }
}