class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if (arr[i]=='(' || arr[i]=='[' || arr[i]=='{'){
                stack.push(arr[i]);
            }
            else if (stack.isEmpty()){
                return false;
            }
            else if (arr[i] == ')' && stack.peek() == '(' ){
                stack.pop();
            }
            else if (arr[i] == ']' && stack.peek() == '[' ){
                stack.pop();
            }
            else if (arr[i] == '}' && stack.peek() == '{' ){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
