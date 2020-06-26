import java.util.Scanner;

import java.util.Scanner;
public class WeirdAlgorithm {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();

        String out = "" + n;

        while(n > 1) {
            if(n%2 == 1) n = n*3 + 1;
            else n /= 2;
            out += " " + n;
        }

        System.out.println(out);
    }
}