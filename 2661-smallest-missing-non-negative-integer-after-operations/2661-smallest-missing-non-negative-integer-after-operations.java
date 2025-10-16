class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        if (value <= 20000) {
            int[] freq = new int[value];
            for(int x : nums) {
                int r = ((x % value) + value) % value;
                freq[r]++;
            }

            int k = 0;
            while(true) {
                int r = k % value;
                if(freq[r] == 0) return k;
                freq[r]--;
                k++;
            }
        } else {
            Map<Integer, Integer> freq = new HashMap<>();
            for(int x : nums) {
                int r = (int)(((long)x % value + value) % value);
                freq.put(r, freq.getOrDefault(r, 0) + 1);
            }
            int k = 0;
            while(true) {
                int r = (int)(k % (long)value);
                int c = freq.getOrDefault(r, 0);
                if(c == 0) return k;
                if(c == 1) freq.remove(r);
                else freq.put(r, c - 1);
                k++;
            }
        }
    }
}