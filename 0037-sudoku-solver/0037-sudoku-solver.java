import java.util.*;

class Solution {
    private final int FULL = (1 << 9) - 1; 

    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        List<int[]> empties = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    empties.add(new int[]{r, c});
                } else {
                    int d = ch - '1';
                    int b = (r / 3) * 3 + (c / 3);
                    int bit = 1 << d;
                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[b] |= bit;
                }
            }
        }

        dfs(board, empties, 0, rows, cols, boxes);
    }

    private boolean dfs(char[][] board, List<int[]> empties, int k,
                        int[] rows, int[] cols, int[] boxes) {
        if (k == empties.size()) return true;

        int bestIdx = -1, bestCount = 10, maskForBest = 0;
        for (int i = k; i < empties.size(); i++) {
            int r = empties.get(i)[0], c = empties.get(i)[1];
            int b = (r / 3) * 3 + (c / 3);
            int used = rows[r] | cols[c] | boxes[b];
            int candidates = FULL & ~used;
            int cnt = Integer.bitCount(candidates);
            if (cnt < bestCount) {
                bestCount = cnt;
                bestIdx = i;
                maskForBest = candidates;
                if (cnt == 1) break; 
            }
        }
        if (bestCount == 0) return false; 

        Collections.swap(empties, k, bestIdx);
        int r = empties.get(k)[0], c = empties.get(k)[1];
        int b = (r / 3) * 3 + (c / 3);

        
        for (int cand = maskForBest; cand != 0; cand &= cand - 1) {
            int bit = cand & -cand; 
            int d = Integer.numberOfTrailingZeros(bit); 
            board[r][c] = (char) ('1' + d);
            rows[r] |= bit;
            cols[c] |= bit;
            boxes[b] |= bit;

            if (dfs(board, empties, k + 1, rows, cols, boxes)) return true;

            // Gỡ
            rows[r] &= ~bit;
            cols[c] &= ~bit;
            boxes[b] &= ~bit;
            board[r][c] = '.';
        }

        Collections.swap(empties, k, bestIdx);
        return false;
    }
}
