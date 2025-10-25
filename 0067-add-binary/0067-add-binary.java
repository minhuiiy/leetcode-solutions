class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while(i >= 0 || j >= 0 || carry != 0) {
            int ai = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bj = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = ai + bj + carry;
            sb.append(sum & 1);
            carry = sum >> 1;
        }

        return sb.reverse().toString();
    }
}