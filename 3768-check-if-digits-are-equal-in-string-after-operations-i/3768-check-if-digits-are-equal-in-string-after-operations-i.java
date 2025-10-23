class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        if(n <= 2) return s.charAt(0) == s.charAt(n - 1);

        int num1 = 0, num2 = 0;

        int[] comb = new int[n - 1];
        comb[0] =  1;
        for(int i = 0; i < n - 1; i++) {
            int[] next = new int[i + 1];
            next[0] = next[i] = 1;
            for(int j = 1; j < i; j++) {
                next[j] = (comb[j - 1] + comb[j]) % 10;
            }
            comb = next;
        }

        for(int i = 0; i < n - 1; i++) {
            int coef = comb[i];
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i + 1) - '0';
            num1 = (num1 + coef * d1) % 10;
            num2 = (num2 + coef * d2) % 10;
        }

        return num1 == num2;
    }
}