class Solution {
  public int maxPartitionsAfterOperations(String s, int k) {
    Map<Long, Integer> mem = new HashMap<>();
    return dp(s, 0, true, 0, k, mem) + 1;
  }

  private int dp(final String s, int i, boolean canChange, int mask,
                 int k, Map<Long, Integer> mem) {
    if (i == s.length()) return 0;

    long key = ((long) i << 27) | ((canChange ? 1L : 0L) << 26) | (mask & ((1 << 26) - 1));
    Integer cached = mem.get(key);
    if (cached != null) return cached;

    int res = getRes(s, i, canChange, mask, 1 << (s.charAt(i) - 'a'), k, mem);

    if (canChange) {
      for (int j = 0; j < 26; ++j) {
        res = Math.max(res, getRes(s, i, false, mask, 1 << j, k, mem));
      }
    }

    mem.put(key, res);
    return res;
  }

  private int getRes(final String s, int i, boolean nextCanChange, int mask,
                     int newBit, int k, Map<Long, Integer> mem) {
    int newMask = mask | newBit;
    if (Integer.bitCount(newMask) > k) {
      return 1 + dp(s, i + 1, nextCanChange, newBit, k, mem);
    }
    return dp(s, i + 1, nextCanChange, newMask, k, mem);
  }
}
