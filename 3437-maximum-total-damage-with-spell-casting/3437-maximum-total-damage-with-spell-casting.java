class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> sum = new HashMap<>();
        for (int p : power) sum.merge(p, (long) p, Long::sum);

        List<Integer> vals = new ArrayList<>(sum.keySet());
        Collections.sort(vals);
        int m = vals.size();
        long[] gain = new long[m];
        for (int i = 0; i < m; i++) gain[i] = sum.get(vals.get(i));

        long[] dp = new long[m];
        int j = -1;
        for (int i = 0; i < m; i++) {
            while (j + 1 < i && vals.get(i) - vals.get(j + 1) > 2) j++;
            long take = gain[i] + (j >= 0 ? dp[j] : 0);
            long skip = i > 0 ? dp[i - 1] : 0;
            dp[i] = Math.max(skip, take);
        }
        return dp[m - 1];
    }
}