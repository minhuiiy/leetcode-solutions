class Solution {
    public boolean isValid(String s) {
       Map<Character, Character> map = new HashMap<>();
       map.put(')', '(');
       map.put('}', '{');
       map.put(']', '[');

       Stack<Character> stack = new Stack<>();

       for(char ch : s.toCharArray()) {
        if(ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        }else {
            if(stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();

            if(top != map.get(ch)) {
                return false;
            }
        }
       }

       return stack.isEmpty();
    }
}