import java.util.Scanner;

public class CountingValleys {

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        int steps = Integer.parseInt(input.nextLine());
        String path = input.nextLine();

        int valleys = 0;
        int up = 0, down = 0;

        for(int i=0;i<path.length();i++) {
            if(path.charAt(i) == 'U' || path.charAt(i) == 'D') {
                if(path.charAt(i) == 'U') {
                    up++;
                } else{
                    down++;
                }

                if(up-down == 0) {
                    if(path.charAt(i) == 'U') {
                        valleys++;
                    }
                }
            }
        }

        System.out.println(valleys);

    }
}
