class Solution {
    public int totalMoney(int n) {
        int ans = 0, start = 1;
        for(int day = 0; day < n; ) {
            int x = start;
            for(int d = 0; d < 7 && day<  n; d++, day++) {
              ans += x++;  
            }
            start++;
        }
        return ans;
    }
}