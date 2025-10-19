class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String best = s;
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.offer(s);
        seen.add(s);

        while(!q.isEmpty()) {
            String cur = q.poll();
            if(cur.compareTo(best) < 0) best = cur;

            String added = addOdd(cur, a);
            if(seen.add(added)) q.offer(added);

            String rotated = rotateRight(cur, b);
            if(seen.add(rotated)) q.offer(rotated);
        }
        return best;
    }

    private String addOdd(String s, int a) {
        char[] arr = s.toCharArray();
        for(int i = 1; i < arr.length; i += 2) {
            int d = arr[i] - '0';
            d = (d + a) % 10;
            arr[i] = (char) (d + '0');
        }
        return new String(arr);
    }

    private String rotateRight(String s, int b) {
        int n = s.length();
        int k = b % n;
        if(k == 0) return s;
        return s.substring(n - k) + s.substring(0, n - k);
    }
}