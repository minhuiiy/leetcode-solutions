class Solution {
    private int ans = 0;
    private int full;

    public int totalNQueens(int n) {
        full = (1 << n) - 1;
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int cols, int d1, int d2) {
        if(cols == full) {ans++; return;}

        int avail = full & ~(cols | d1 | d2);
        while(avail != 0) {
            int pick = avail & -avail;
            avail -= pick;
            dfs(cols | pick, (d1 | pick) << 1, (d2 | pick) >>> 1);
        }
    }
}