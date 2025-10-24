class Solution {
    public int nextBeautifulNumber(int n) {
        String target = String.valueOf(n);
        int lenN = target.length();

        String best = null;
        for (int L = lenN; L <= 10; L++) { 
            List<int[]> subsets = new ArrayList<>();
            pickDigits(1, L, new int[10], subsets); 
            if (L == lenN) {
                for (int[] cnt : subsets) {
                    String cand = firstPermGreater(cnt, target);
                    if (cand != null && (best == null || cmp(cand, best) < 0)) best = cand;
                }
                if (best != null) return Integer.parseInt(best);
            } else {

                String minOfThisLen = null;
                for (int[] cnt : subsets) {
                    String s = buildMin(cnt); 
                    if (minOfThisLen == null || cmp(s, minOfThisLen) < 0) minOfThisLen = s;
                }
                if (minOfThisLen != null) return Integer.parseInt(minOfThisLen);
            }
        }

        throw new RuntimeException("No answer found");
    }

    private void pickDigits(int d, int remain, int[] cnt, List<int[]> out) {
        if (remain == 0) { out.add(cnt.clone()); return; }
        if (d > 9 || remain < 0) return;
        pickDigits(d + 1, remain, cnt, out);
        if (remain >= d) {
            cnt[d] = d;
            pickDigits(d + 1, remain - d, cnt, out);
            cnt[d] = 0;
        }
    }

    private String firstPermGreater(int[] cnt, String target) {
        int L = target.length();

        int[] arr = toArray(cnt); 
        if (arr.length == 0) return null;

        do {
            if (greaterThan(arr, target)) return digitsToString(arr);
        } while (nextPerm(arr));
        return null;
    }

    private String buildMin(int[] cnt) {
        int[] arr = toArray(cnt);
        return digitsToString(arr);
    }

    private int[] toArray(int[] cnt) {
        int L = 0;
        for (int d = 1; d <= 9; d++) L += cnt[d];
        int[] arr = new int[L];
        int idx = 0;
        for (int d = 1; d <= 9; d++) {
            for (int k = 0; k < cnt[d]; k++) arr[idx++] = d;
        }
        return arr;
    }

    private boolean greaterThan(int[] digits, String target) {
        if (digits.length != target.length()) return digits.length > target.length();
        for (int i = 0; i < digits.length; i++) {
            int td = target.charAt(i) - '0';
            if (digits[i] != td) return digits[i] > td;
        }
        return false; 
    }

    private String digitsToString(int[] digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int d : digits) sb.append((char) ('0' + d));
        return sb.toString();
    }

    private boolean nextPerm(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = a.length - 1;
        while (a[j] <= a[i]) j--;
        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }

    private int cmp(String x, String y) {
        if (x.length() != y.length()) return Integer.compare(x.length(), y.length());
        return x.compareTo(y);
    }
}
