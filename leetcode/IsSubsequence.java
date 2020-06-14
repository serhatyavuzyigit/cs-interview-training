class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        
        if(s.equals("") && t.equals("")) return true;
        if(s.equals("")) return true;
        if(t.equals("")) return false; 
        
        for(int i=0; i<t.length(); i++) {
            
            if(t.charAt(i) == s.charAt(j)) {
                System.out.println(s.charAt(j));
                j++;
            }
            
            if(j == s.length()) return true;
        }

        return j == s.length();
    }
}