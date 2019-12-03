import java.util.HashMap;

public class CheckPermutation {
    public static void main(String[] args) {
        
        String str1 = "aabbccddeeffgghhiiwyz";
        String str2 = "abcduefg";

        System.out.println(checkPermutation(str1, str2));
    }

    private static boolean checkPermutation(String str1, String str2){
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char c = str1.charAt(i);
            if(map1.containsKey(c)){
                int occurence = map1.get(c);
                map1.replace(c, occurence, occurence+1);
            } else{
                map1.put(c,1);
            }
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<str2.length();i++){
            char c = str2.charAt(i);
            if(!map1.containsKey(c)){
                return false;
            }
            if(map2.containsKey(c)){
                int occurence = map2.get(c);
                map2.replace(c, occurence, occurence+1);
                if(map1.get(c) < occurence){
                    return false;
                }
            } else{
                map2.put(c,1);
            }
        }
        return true;
    }
}      