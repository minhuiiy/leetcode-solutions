class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int i = 0, j = 0;
        int startIdx = -1;
        int matchIdx = 0;

        while(i<n) {
            if(j < m && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++; j++;
            } else if (j < m && p.charAt(j) == '*') {
                startIdx = j++;
                matchIdx = i;
            } else if (startIdx != -1) {
                j = startIdx + 1;
                i = ++matchIdx;
            } else {
                return false;
            }
        }
        while(j < m && p.charAt(j) == '*') j++;
        return j == m;
    }
}