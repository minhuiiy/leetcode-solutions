class Solution {
    private static final String[] MAPPING = {
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if(digits == null || digits.length() == 0) return result;

      backtrack(result, new StringBuilder(), digits, 0);
      return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = MAPPING[digits.charAt(index) - '0'];
        for(char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}