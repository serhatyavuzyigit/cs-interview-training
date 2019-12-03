import java.util.*;

public class SockMerchant {


    private static List<Integer> socks;
    private static int pairs;

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);

        socks = new ArrayList<>();
        int length = Integer.parseInt(input.nextLine());
        pairs = 0;

        for(int i=0;i<length;i++) {
            int sock = input.nextInt();
            if(i == 0) {
                socks.add(sock);
            } else {
                lookForDuplicate(sock);
            }
        }

        System.out.println(pairs);
    }

    private static void lookForDuplicate(int sock) {
        int inFlag = 0;
        for(int i=0;i<socks.size();i++) {
            if(socks.get(i) == sock) {
                pairs++;
                socks.remove(i);
                inFlag = 1;
                break;
            }
        }
        if(inFlag == 0) {
            socks.add(sock);
        }
    }
}
