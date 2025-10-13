class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String lastSig = null;

        for(String w : words) {
            String sig = sortedSignature(w);
            if(lastSig == null || !sig.equals(lastSig)) {
                ans.add(w);
                lastSig = sig;
            }
        }

        return ans;
    }

    private String sortedSignature(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}