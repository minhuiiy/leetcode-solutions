class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int val = 1;

        while(top <= bottom && left <= right) {
            for(int c = left; c <= right; c++) a[top][c] = val++;
            top++;

            for(int r = top; r <= bottom; r++) a[r][right] = val++;
            right--;

            if(top <= bottom) {
                for(int c = right; c >= left; c--) a[bottom][c] = val++;
                bottom--;
            }

            if(left <= right) {
                for(int r = bottom; r >= top; r--) a[r][left] = val++;
                left++;
            }
        }
        return a;
    }
}