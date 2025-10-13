class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];

        for(int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for(int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int mul = a * b;
                int p2 = i + j + 1;
                int p1 = i + j;

                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(k < res.length && res[k] == 0) k++;
        for(; k < res.length; k++) sb.append(res[k]);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}