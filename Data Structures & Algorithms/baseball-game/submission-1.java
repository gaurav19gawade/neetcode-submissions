class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String str : operations) {
            if (str.equals("C")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (str.equals("D")) {
                if (!stack.isEmpty()) {
                    int previous = stack.pop();
                    stack.push(previous);
                    stack.push(previous * 2);
                }
            } else if (str.equals("+")) {
                if (stack.size() >= 2) {
                    int last = stack.pop();
                    int next = stack.pop();
                    int total = last + next;
                    stack.push(next);
                    stack.push(last);
                    stack.push(total);
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}