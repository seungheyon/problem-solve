import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(str[1]);
        //String[] str = br.readLine().split(" ");

        List<Integer> primes = eratosthenes_che(2000000);

        for (Integer prime : primes) {
            if(prime>=n&&isPalindrome(prime)){
                System.out.println(prime);
                return;
            }
        }

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
    
    private static boolean isPalindrome(int n){
        String nStr = String.valueOf(n);
        char[] ncharArr = nStr.toCharArray();
        int size = nStr.length();
        for(int i=0;i<size/2;i++){
            if(ncharArr[i]!=ncharArr[size-1-i]){
                return false;
            }
        }
        return true;
    }
}