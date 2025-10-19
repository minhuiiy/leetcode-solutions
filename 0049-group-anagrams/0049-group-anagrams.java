class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String s : strs) {
            int[] cnt = new int[26];
            for(int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(cnt);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}