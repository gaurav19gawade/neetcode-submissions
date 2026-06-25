class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();


        for(String token: tokens){
            if(token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(token.equals("-")){
                int firstNumber = Integer.valueOf(stack.pop());
                int secondNumber = Integer.valueOf(stack.pop());
                stack.push(secondNumber - firstNumber);
            }else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(token.equals("/")){
                int firstNumber = Integer.valueOf(stack.pop());
                int secondNumber = Integer.valueOf(stack.pop());
                stack.push(secondNumber / firstNumber);
            }else{
                stack.push(Integer.valueOf(token));
            }
        }

        return Integer.valueOf(stack.peek());
    }
}
