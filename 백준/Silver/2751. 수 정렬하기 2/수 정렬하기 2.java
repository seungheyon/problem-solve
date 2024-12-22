
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        Scanner sc = new Scanner(System.in);

        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        for(int number : num){
            System.out.println(number);
        }
    }
}