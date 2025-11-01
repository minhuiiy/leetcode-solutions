class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        List<Integer> cand = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) cand.add(i);

        int rem = k - 1;
        StringBuilder sb = new StringBuilder(n);

        for(int i = n; i >= 1; i--) {
            int block = fact[i - 1];
            int idx = rem / block;
            sb.append(cand.get(idx));
            cand.remove(idx);
            rem %= block;
        }
        return sb.toString();
    }
}