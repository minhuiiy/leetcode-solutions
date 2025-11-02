class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] g : guards) grid[g[0]][g[1]] = 1;
        for(int[] w : walls) grid[w[0]][w[1]] = 2;

        boolean[][] guarded = new boolean[m][n];

        for(int r = 0; r < m; r++) {
            boolean seen = false;
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 2) seen = false;
                else if(grid[r][c] == 1) seen = true;
                else if(seen) guarded[r][c] = true;
            }
        }

        for(int r = 0; r < m; r++) {
            boolean seen = false;
            for(int c = n - 1; c >= 0; c--) {
                if(grid[r][c] == 2) seen = false;
                else if(grid[r][c] == 1) seen = true;
                else if(seen) guarded[r][c] = true;
            }
        }

        for(int c = 0; c < n; c++) {
            boolean seen = false;
            for(int r = 0; r < m; r++) {
                if(grid[r][c] == 2) seen = false;
                else if(grid[r][c] == 1) seen = true;
                else if (seen) guarded[r][c] = true;
            }
        }

        for (int c = 0; c < n; c++) {
            boolean seen = false;
            for (int r = m - 1; r >= 0; r--) {
                if (grid[r][c] == 2) seen = false;
                else if (grid[r][c] == 1) seen = true;
                else if (seen) guarded[r][c] = true;
            }
        }

        int ans = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0 && !guarded[r][c]) ans++;
            }
        }
        return ans;
    }
}