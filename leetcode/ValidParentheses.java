// https://leetcode.com/problems/valid-parentheses/

class ValidParentheses {
    public boolean isValid(String s) {
        
        if(s.length()%2 == 1) return false;
        
        Stack<Character> stack = new Stack<>();
        String openings = "({[";
        String closings = ")}]";
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(openings.indexOf(c) != -1) {
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                
                char popedElement = stack.pop();
                if(popedElement=='(' && c!=')') return false;
                if(popedElement=='{' && c!='}') return false;
                if(popedElement=='[' && c!=']') return false;
            }
        }
        
        if(stack.empty()) return true;
        
        return false;
    }
}