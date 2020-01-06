import java.util.Scanner;

public class ForegonSolution{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        String result = "";
        for(int i=0;i<t;i++){
            String N = input.next();
            if(N.length() == 1){
                result += "Case #" + (i+1) + ": 2 2\n";
            } else{
                String a = "";
                String b = "";
                for(int j=0;j<N.length();j++){
                    char c = N.charAt(j);
                    if(c == '4'){
                        a += "2";
                        b += "2";
                    } else{
                        if(a.length() != 0){
                            a += "0";
                        }
                        b += c;
                    }
                }
                result += "Case #" + (i+1) + ": " + a + " " + b + "\n";
            }

        }

        System.out.print(result);
    }
}