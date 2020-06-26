import java.util.Scanner;

public class Repetitions {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String seq = input.next();
        int max = 0;
        if (seq.length() == 0) System.out.println(0);
        else if (seq.length() == 1) System.out.println(1);
        else {
            int localCounter = 1;
            for(int i=0; i<seq.length()-1; i++) {
                int j = i+1;
                if(seq.charAt(i) == seq.charAt(j)) localCounter++;
                else {
                    if(localCounter > max) max = localCounter;
                    localCounter = 1;
                }
            }
            if(localCounter > max) max = localCounter;
            System.out.println(max);
        }
     }
}