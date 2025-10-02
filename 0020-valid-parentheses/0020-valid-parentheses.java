class Solution {
    public boolean isValid(String s) {
       HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[' ) {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(top != map.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}