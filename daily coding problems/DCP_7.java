public class DCP_7 {

    public static void main(String[] args) {
        String message = "111";
        int totalWays = countDecodeWays(message);
        System.out.println(totalWays);
    }

    private static int countDecodeWays(String message) {
        if(message.length() == 1)
            return 1;

        if(message.length() == 2){
            if(message.charAt(1) == '0')
                return 1;

            int num = Integer.parseInt(message);
            if(num < 27)
                return 3;

            return 2;
        }

        int count = 1;
        int subCount = 0;
        for(int i=0; i<message.length()-1; i++) {
            String subNumber = message.substring(i, i+2);

            if(subNumber.charAt(0) != '0') {
                int num = Integer.parseInt(subNumber);
                if(num < 27) {
                    subCount++;
                }
            }
        }

        int threesCount = 0;
        for(int i=0; i<message.length()-2; i++) {
            String subNumber = message.substring(i, i+3);
            if((subNumber.charAt(0) == '1' || subNumber.charAt(0) == '2') && (subNumber.charAt(1) == '1' || subNumber.charAt(1) == '2')) {
                threesCount++;
            }
        }

        if(subCount == 0)
            return count;

        int totalCombination = calcTotalCombination(subCount, threesCount);

        return totalCombination + count;

    }

    private static int calcTotalCombination(int subCount, int threesCount) {
        int sum = 0;
        int nThFact = findFactorial(subCount);
        for(int i=1; i<=subCount; i++) {
            int val = calcCombination(nThFact, subCount-i, i);
            if(i>1) {
                val -= threesCount;
            }

            sum += val;
        }
        return sum;
    }

    private static int findFactorial(int n) {
        if(n == 0)
            return 1;
        int fact = 1;
        for(int i=1; i<=n; i++)
            fact *= i;

        return fact;
    }

    private static int calcCombination(int nFactValue, int n_r, int r) {
        int n_rThFact = findFactorial(n_r);
        int rThFact = findFactorial(r);
        return nFactValue / (n_rThFact*rThFact);
    }
}