import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        //int n = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(str[1]);
        String[] str = br.readLine().split(" ");
        double m = Double.parseDouble(str[0]);
        double n = Double.parseDouble(str[1]);
        int num = (int)Math.sqrt(n);

        List<Integer> primes = eratosthenes_che(num);
        int count = 0;

        // Count "almost primes" within range [a, b]
        for (int prime : primes) {
            long power = (long) prime * prime; // Start with p^2
            while (power <= n) {
                if (power >= m) {
                    count++;
                }
                // Avoid overflow when calculating the next power
                if (power > n / prime) {
                    break;
                }
                power *= prime; // Move to the next power
            }
        }

        System.out.println(count);
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

    private static int greaterPower(int n, double a, double b){
        double logN = Math.log(n);  // Precompute log(n)
        int kMax = (int) (Math.log(b) / logN); // Maximum exponent
        int kMin = (int) (Math.log(a) / logN);  // Minimum exponent
        if(a>1){
            kMin = (int) (Math.log(a-1) / logN);  
        }
        if(kMax>0){
            kMax--;
        }
        if(kMin>0){
            kMin--;
        }

        //System.out.println("when prime = "+n+", a : "+a+", b : "+b+" // log(b) : "+kMax+", log(a) : "+kMin);

        // Return the count of valid powers
        return  kMax - kMin;
    }
}