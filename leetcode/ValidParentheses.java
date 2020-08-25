// https://leetcode.com/problems/valid-parentheses/

class ValidParentheses {
    public boolean isValid(String s) {
        if(s.equals(""))
            return true;
        
        String closeChars = ")]}";
        String openChars = "([{";
        
        Stack<Character> charsStack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(openChars.indexOf(c) != -1) {
                charsStack.push(c);
            } else {
                if(charsStack.empty())
                    return false;
                char poppedChar = charsStack.pop();
                if(openChars.indexOf(poppedChar) != closeChars.indexOf(c))
                    return false;
            }
        }
        
        if(charsStack.empty())
            return true;
        
        return false;
        
    }
}