import java.util.Scanner;

public class EvenDigits {
 
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int num_test = input.nextInt();
        String output = "";
        for(int i=0; i<num_test; i++) {
            int num_button;
            String num = input.next();
            if(isAllEven(num)){
                num_button = 0;
            } else {
                num_button = process_num(num);
            }
            output += "Case #" + (i + 1) + ": " + num_button + "\n";
        }
        
        System.out.print(output);
    }

    private static boolean isAllEven(String num) {
        for(int i=0; i<num.length(); i++) {
            if(((num.charAt(i) - '0') % 2) == 1) {
                return false;
            }
        }
        return true;
    }

    private static int process_num(String num) {
        int plus_num_button = plus_process(num);
        int minus_num_button = minus_process(num);

        return Math.min(plus_num_button, minus_num_button);
    }   

    private static int plus_process(String num) {
        int original_num = Integer.parseInt(num);
        int odd_digit_index = -1;
        for(int i=0;i<num.length();i++){
            if(((num.charAt(i) - '0') % 2) == 1){
                odd_digit_index = i;
                break;
            }
        }
        int ten_pow_num = num.length() - odd_digit_index - 1;
        char plus_digit = (char)((int)num.charAt(odd_digit_index) + 1);
        int left_sub_number = Integer.parseInt(num.substring(0,odd_digit_index) + plus_digit);
        int new_num = left_sub_number * ((int)(Math.pow(10, ten_pow_num)));
        return new_num - original_num;
    }

    private static int minus_process(String num) {
        int original_num = Integer.parseInt(num);
        int odd_digit_index = -1;
        for(int i=0;i<num.length();i++){
            if(((num.charAt(i) - '0') % 2) == 1){
                odd_digit_index = i;
                break;
            }
        }
        char minus_digit = (char)((int)num.charAt(odd_digit_index) - 1);
        int num_of_eights = num.length() - odd_digit_index - 1;
        String eight = "8";
        String repeated_eight = new String(new char[num_of_eights]).replace("\0", eight);
        int new_num = Integer.parseInt(num.substring(0, odd_digit_index) + minus_digit + repeated_eight);
        return original_num - new_num;

    }
}
