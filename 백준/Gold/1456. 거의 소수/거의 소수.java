import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        //int n = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(str[1]);
        String[] str = br.readLine().split(" ");
        long m = Long.parseLong(str[0]);
        long n = Long.parseLong(str[1]);
        int num = (int)Math.sqrt(n);

        List<Integer> primes = eratosthenes_che(num);
        int sum = 0;
        for (Integer prime : primes) {
            int asd = greaterPower(prime,m, n);
            //System.out.println(asd);
            sum += asd;
        }
        System.out.println(sum);
    }
    
    private static List<Integer> eratosthenes_che(int number){
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[number+1];
        for(int i=2;i<=number;i++){
            isPrime[i] = true;
        }
        for(int i=2;i*i<=number;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=number;j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2;i<=number;i++){
            if(isPrime[i]){
                result.add(i);
            }
        }

        return result;
    }

    private static int greaterPower(int n, long a, long b){
        long power = (long)n*n;
        int cnt = 0;
        while(power<=b){
            if(power>=a){
                cnt++;
            }
            if(power>b/n){
                return cnt;
            }
            power *=n;
        }
        return cnt;
    }
}