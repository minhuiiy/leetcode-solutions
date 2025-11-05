import java.util.*;

class Solution {
    static final class Pair {
        final int val;
        final int freq;
        Pair(int v, int f) { val = v; freq = f; }
    }
    static final class ByStrength implements Comparator<Pair> {
        @Override public int compare(Pair a, Pair b) {
            if (a.freq != b.freq) return Integer.compare(b.freq, a.freq);
            if (a.val  != b.val ) return Integer.compare(b.val,  a.val );
            return 0; 
        }
    }

    private final Comparator<Pair> cmp = new ByStrength();

    private Map<Integer,Integer> cnt;
    private TreeSet<Pair> top, rest;
    private Set<Integer> inTop;
    private long sumTop;
    private int x;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        this.x = x;
        cnt   = new HashMap<>();
        top   = new TreeSet<>(cmp);
        rest  = new TreeSet<>(cmp);
        inTop = new HashSet<>();
        sumTop = 0L;

        long[] ans = new long[n - k + 1];

        for (int i = 0; i < k; i++) add(nums[i]);
        ans[0] = sumTop;

        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = sumTop;
        }
        return ans;
    }

    private void add(int v) {
        int old = cnt.getOrDefault(v, 0);
        if (old > 0) {
            Pair pOld = new Pair(v, old);
            if (inTop.contains(v)) {
                top.remove(pOld);
                sumTop -= 1L * v * old;
                inTop.remove(v);
            } else {
                rest.remove(pOld);
            }
        }
        int now = old + 1;
        cnt.put(v, now);
        rest.add(new Pair(v, now));
        rebalance();
    }

    private void remove(int v) {
        int old = cnt.getOrDefault(v, 0);
        if (old == 0) return;                 
        Pair pOld = new Pair(v, old);
        if (inTop.contains(v)) {
            top.remove(pOld);
            sumTop -= 1L * v * old;
            inTop.remove(v);
        } else {
            rest.remove(pOld);
        }

        int now = old - 1;
        if (now == 0) {
            cnt.remove(v);
        } else {
            rest.add(new Pair(v, now));
            cnt.put(v, now);
        }
        rebalance();
    }

    private void rebalance() {
        while (top.size() < x && !rest.isEmpty()) {
            Pair best = rest.pollFirst();   
            top.add(best);
            inTop.add(best.val);
            sumTop += 1L * best.val * best.freq;
        }
        while (!top.isEmpty() && !rest.isEmpty()) {
            Pair bestRest = rest.first();
            Pair worstTop = top.last();
            if (stronger(bestRest, worstTop)) {
                top.remove(worstTop);
                inTop.remove(worstTop.val);
                sumTop -= 1L * worstTop.val * worstTop.freq;
                rest.add(worstTop);

                rest.pollFirst();
                top.add(bestRest);
                inTop.add(bestRest.val);
                sumTop += 1L * bestRest.val * bestRest.freq;
            } else break;
        }
    }

    private boolean stronger(Pair a, Pair b) {
        if (a.freq != b.freq) return a.freq > b.freq;
        return a.val > b.val;
    }
}
