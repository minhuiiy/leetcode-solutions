class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;

        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            diff[l]++;
            if (r + 1 < n) diff[r + 1]--;
        }
        int cover = 0;
        for (int i = 0; i < n; i++) {
            cover += diff[i];
            if (cover < nums[i]) return -1;
        }

        List<List<Integer>> startAt = new ArrayList<>();
        for (int i = 0; i < n; i++) startAt.add(new ArrayList<>());
        for (int[] q : queries) startAt.get(q[0]).add(q[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int[] drop = new int[n + 2]; 
        int active = 0;              
        int picked = 0;              

        for (int i = 0; i < n; i++) {
            active -= drop[i];                    
            for (int r : startAt.get(i)) pq.offer(r); 
            while (!pq.isEmpty() && pq.peek() < i) pq.poll(); 

            int need = nums[i];
            while (active < need) {
                if (pq.isEmpty()) return -1;      
                int r = pq.poll();                
                picked++;
                active++;
                drop[r + 1]++;                   
            }
        }

        return m - picked;
    }
}