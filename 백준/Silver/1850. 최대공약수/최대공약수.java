import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        long a = Long.parseLong(str[0]);
        long b = Long.parseLong(str[1]);
        long result;
        if(a>=b){
            result = gcd(a, b);
        }
        else{
            result = gcd(b, a);
        }
        StringBuilder string = new StringBuilder();
        for(long i=0;i<result;i++){
            string.append("1");
        }

        System.out.println(string);

    }
    
    private static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}