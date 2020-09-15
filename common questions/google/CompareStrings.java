
import java.util.Arrays;

public class CompareStrings {

    public static void main(String[] args) {

        String [] A = {"abcd", "aabc", "bd"};
        String [] B = {"aaa", "aa"};

        int [] freqsA = computeFrequencies(A);
        int [] freqsB = computeFrequencies(B);

        Arrays.sort(freqsA);
        Arrays.sort(freqsB);

        int [] result = new int [B.length];

        for(int i=0; i<freqsB.length; i++) {
            int j = 0;
            while(j<freqsA.length && freqsA[j] < freqsB[i])
                j++;
            result[i] = j;
        }
        for(int i=0; i<result.length; i++)
            System.out.println(result[i]);
    }

    private static int[] computeFrequencies(String[] A) {
        int [] result = new int [A.length];
        int i = 0;
        for(String s: A) {
            int f = freq(s);
            result[i] = f;
            i++;
        }
        return result;
    }

    private static int freq(String s) {
        char min = 'z';
        int freq = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c==min) freq++;
            if(c<min) {
                freq = 1;
                min = c;
            }
        }
        return freq;
    }


}
