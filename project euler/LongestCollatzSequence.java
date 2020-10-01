public class LongestCollatzSequence {

    public static void main(String[] args) {
        
        // result is 837799 with 525 sequence

        long max = 0;
        long res = 0;
        for(long i=999999; i>700000; i--) {
            long start = i;
            long counter = 0;
            while(start != 1) {
                if(start%2 == 1)
                    start = start*3 + 1;
                else
                    start = start / 2;
                counter++;

            }
            if(max < counter) {
                max = counter;
                res = i;
                System.out.println(res);
            }
        }
        System.out.println("num: " + res + " sequence: " + max);
    }
    
}
