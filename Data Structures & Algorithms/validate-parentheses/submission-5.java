class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if(s.length() <= 1){
            return false;
        }

        for(Character c: s.toCharArray()){
            System.out.println(c);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            } else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.size() == 0;
    }
}
