class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> line = new TreeMap<>();
        TreeSet<Integer> cand = new TreeSet<>();

        for(int x : nums) {
            count.merge(x, 1, Integer::sum);
            line.merge(x - k, 1, Integer::sum);
            line.merge(x + k + 1, -1, Integer::sum);
            cand.add(x);
            cand.add(x - k);
            cand.add(x + k + 1);
        }

        int ans = 1;
        int cover = 0;
        for(int v : cand) {
            cover += line.getOrDefault(v, 0);
            int eq = count.getOrDefault(v, 0);
            int canAdjust = cover - eq;
            ans = Math.max(ans, eq + Math.min(numOperations, canAdjust));
        }
        return ans;
    }
}