public class StringCompression{
    public static void main(String[] args) {
        String original = "aabcccccaaa";
        String compressed = compress(original);

        if(original.length() < compressed.length()){
            System.out.println(original);
        } else {
            System.out.println(compressed);
        }
    }

    private static String compress(String original){
        String output = "";
        int index = 0;
        while(index < original.length()){
            char c = original.charAt(index);
            int j = index + 1;
            int occurence = 1;
            while((j < original.length()) && (original.charAt(j) == c)){
                occurence++;
                j++;
            }
            index = j;
            output += c + "" + occurence;
        }
        return output; 
    }
}