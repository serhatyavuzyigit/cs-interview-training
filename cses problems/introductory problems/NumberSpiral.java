import java.util.Scanner;

public class NumberSpiral {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long t = input.nextLong();
        String answer = "";
        for(int i=0; i<t; i++) {
            long y = input.nextLong();
            long x = input.nextLong();
            long max = Math.max(y,x);
            long diagonal = computeDiagonal(max+1);
            
            if(x>y) {
                if(max%2 == 0) answer += diagonal - (x-y) + "\n";
                else answer += diagonal + (x-y) + "\n";
            } else if(x<y){
                if(max%2 == 0) answer += diagonal + (y-x) + "\n";
                else answer += diagonal - (y-x) + "\n";
            } else {
                answer += diagonal + "\n";
            }
        }
        System.out.println(answer);
    }

    private static long computeDiagonal(long row) {
        if(row == 2) return 1;
        if(row == 3) return 3;
        return (row-1)*(row-2) + 1;
    }
}