

import java.util.*;

public class Allocation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        String caseResults = "";
        for(int i=0; i<t; i++) {
            int n = input.nextInt();
            int b = input.nextInt();
            int [] costs = new int[n];
            for(int j=0; j<n; j++) {
                costs[j] = input.nextInt();
            }
            int result = compute(costs, b);
            caseResults += "Case #" + (i+1) + ": " + result + "\n";
        }

        System.out.print(caseResults);
    }

    private static int compute(int[] costs, int b) {
        int j = 0;
        int sum = 0;
        Arrays.sort(costs);
        while(j < costs.length) {
            sum += costs[j];
            if(sum > b) break;
            j++;
        }

        return j;
    }
}
