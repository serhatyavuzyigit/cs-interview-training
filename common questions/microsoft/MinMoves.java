// https://leetcode.com/discuss/interview-question/398026/

public class MinMoves {
    public static void main(String[] args) {

        String s = "baaaaa";
        int n = solution(s);
        System.out.println(n);
    }

    private static int solution(String s) {
        int result = 0;

        for(int i=0; i<s.length();) {
            int next = i + 1;
            while (next<s.length() && s.charAt(i)==s.charAt(next))
                next++;
            if(next-i >= 3) {
                if(next-i<=5)
                    result++;
                else
                    result += (next-i)/3;
            }
            i = next;
        }

        return result;
    }


}
