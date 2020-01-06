import java.util.Scanner;

public class YouCanGoYourOwnWay{

    public static void main(String []args){
        
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        String result = "";
        for(int i=0; i<T; i++){
            int N = input.nextInt();
            String Lydia_path = input.next();
            String path = "";
            for(int j=0; j<Lydia_path.length(); j++){
                if(Lydia_path.charAt(j) == 'S'){
                    path += "E";
                } else{
                    // assumed that path consists of S and E's
                    path += "S";
                }
            }
            result += "Case #" + (i+1) + ": " + path + "\n";
        }
        System.out.print(result);
    }    
}