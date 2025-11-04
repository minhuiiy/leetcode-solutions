import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Map<Integer, Integer> freq = new HashMap<>();
        // khởi tạo cửa sổ đầu
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = calc(freq, x);

        // trượt cửa sổ
        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in  = nums[i];

            // remove out
            int fo = freq.get(out) - 1;
            if (fo == 0) freq.remove(out);
            else freq.put(out, fo);

            // add in
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            ans[i - k + 1] = calc(freq, x);
        }
        return ans;
    }

    // Tính X-Sum từ map tần suất
    private int calc(Map<Integer, Integer> freq, int x) {
        // gom (val, freq) rồi sort: freq desc, val desc
        List<int[]> list = new ArrayList<>(freq.size());
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }
        list.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; // freq desc
            return b[0] - a[0];                   // val  desc
        });

        long sum = 0;
        int take = Math.min(x, list.size());
        for (int i = 0; i < take; i++) {
            sum += 1L * list.get(i)[0] * list.get(i)[1];
        }
        return (int) sum; // đề yêu cầu int[]
    }
}
