import java.util.Scanner;

public class URLify {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int length;
        String inputString;
        inputString = input.nextLine();
        length = input.nextInt();

        Character [] chars = new Character[length];
        for(int i=0;i<length;i++){
            chars[i] = inputString.charAt(i);
        }

        String output = "";
        for(int i=0;i<chars.length;i++){
            if(chars[i] == ' '){
                output += "%20";
            } else {
                output += chars[i];
            }
        }

        System.out.println(output);
    }
}