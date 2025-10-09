class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 2; i <= n; i++) {
            s = next(s);
        }
        return s;
    }

    private String next(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, L = s.length();
        while(i < L) {
            char ch = s.charAt(i);
            int j = i;
            while(j < L && s.charAt(j) == ch) j++;
            sb.append(j - i).append(ch);
            i = j;
        }

        return sb.toString();
    }
}