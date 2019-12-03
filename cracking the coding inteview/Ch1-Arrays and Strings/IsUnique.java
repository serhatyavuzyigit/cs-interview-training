public class IsUnique{
    
    public static void main(String[] args) {
        
        String unique = "abcdefghi";
        String notUnique = "aabbccdd";

        demo(unique);
        demo(notUnique);
    }

    /*
        for given string prints appropriate output to stdout
    */
    private static void demo(String word) {
        if(isUnique(word)){
            System.out.println(word + " has all unique characters.");
        } else {
            System.out.println(word + " hasn't all unique characters.");
        }
    }

    /*
        checks the string has all unique characters or not
        I assumed that all characters are from english alphabet
    */
    private static boolean isUnique(String word) {
        boolean [] chars = new boolean[128];
        for(int i=0; i<word.length(); i++) {
            int index = (int)word.charAt(i);
            if(chars[index] == true){
                return false;
            }
            chars[index] = true;
        }
        return true;
    }
}