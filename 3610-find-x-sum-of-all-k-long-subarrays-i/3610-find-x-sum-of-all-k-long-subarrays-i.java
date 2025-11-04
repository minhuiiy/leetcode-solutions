import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = calc(freq, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in  = nums[i];

            int fo = freq.get(out) - 1;
            if (fo == 0) freq.remove(out);
            else freq.put(out, fo);

            freq.put(in, freq.getOrDefault(in, 0) + 1);

            ans[i - k + 1] = calc(freq, x);
        }
        return ans;
    }

    private int calc(Map<Integer, Integer> freq, int x) {
        List<int[]> list = new ArrayList<>(freq.size());
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }
        list.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; 
            return b[0] - a[0];                   
        });

        long sum = 0;
        int take = Math.min(x, list.size());
        for (int i = 0; i < take; i++) {
            sum += 1L * list.get(i)[0] * list.get(i)[1];
        }
        return (int) sum;
    }
}
