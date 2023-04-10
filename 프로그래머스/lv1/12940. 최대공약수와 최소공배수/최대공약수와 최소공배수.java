import java.math.BigInteger;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        BigInteger n1 = BigInteger.valueOf(n);
        BigInteger m1 = BigInteger.valueOf(m);
        BigInteger gcd = n1.gcd(m1);
        int a2 = n*m/gcd.intValue();
        answer[0] = gcd.intValue();
        answer[1] = a2;
        
        return answer;
    }
}