class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // chuỗi rỗng khớp mẫu rỗng

        // Xử lý các mẫu có dạng a*, a*b*, ...
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Điền bảng DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Trường hợp bỏ qua ký tự trước (* = 0 lần)
                    dp[i][j] = dp[i][j - 2];
                    // Trường hợp lặp lại ký tự trước
                    char pPrev = p.charAt(j - 2);
                    if (pPrev == '.' || pPrev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
