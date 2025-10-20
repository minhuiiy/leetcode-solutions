class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        int[] pos = new int[n];

        backtrack(0, n, col, diag1, diag2, pos, ans);
        return ans;
    }

    private void backtrack(int r, int n, boolean[] col, boolean[] d1, boolean[] d2, int[] pos, List<List<String>> ans) {
        if(r == n) {
            ans.add(buildBoard(pos, n));
            return;
        }

        for(int c = 0; c < n; c++) {
            int id1 = r - c + n - 1;
            int id2 = r + c;
            if(col[c] || d1[id1] || d2[id2]) continue;

            col[c] = d1[id1] = d2[id2] = true;
            pos[r] = c;

            backtrack(r + 1, n, col, d1, d2, pos, ans);

            col[c] = d1[id1] = d2[id2] = false;
        }
    }

    private List<String> buildBoard(int[] pos, int n)  {
        List<String> board = new ArrayList<>(n);
        for(int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[pos[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}