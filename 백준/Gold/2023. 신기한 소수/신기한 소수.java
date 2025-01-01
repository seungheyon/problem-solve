import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> intSet = new TreeSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());



        sosu(2, N, 1);
        sosu(3, N, 1);
        sosu(5, N, 1);
        sosu(7, N, 1);



        for(int nsosu : intSet){
            System.out.println(nsosu);
        }


    }

    private static void sosu(int n, int N, int cnt){
        if(isPrime(n)){
            if(cnt==N){
                //Todo: set 또는 list 에 n 추가
                intSet.add(n);
                return;
            }
            sosu(n*10+1, N, cnt+1);
            sosu(n*10+3, N, cnt+1);
            sosu(n*10+7, N, cnt+1);
            sosu(n*10+9, N, cnt+1);
        }

    }


    private static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false; // Found a divisor, so n is not prime
            }
        }
        return true;
    }
}
