import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nk[] = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] num = new int[n];
        String nstr[] = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(nstr[i]);
        }
        Arrays.sort(num);

        System.out.println(num[k-1]);
    }
}