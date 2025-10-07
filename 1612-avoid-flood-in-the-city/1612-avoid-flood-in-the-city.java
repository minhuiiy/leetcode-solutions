class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> sunny = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            int x = rains[i];
            if(x == 0) {
                ans[i] = 1;
                sunny.add(i);
            } else {
                ans[i] = -1;

                if(lastRain.containsKey(x)) {
                    int prev = lastRain.get(x);
                    Integer dryIdx = sunny.higher(prev);
                    if(dryIdx == null) {
                        return new int[0];
                    }

                    ans[dryIdx] = x;
                    sunny.remove(dryIdx);
                }

                lastRain.put(x, i);
            }
        }

        return ans;
    }
}