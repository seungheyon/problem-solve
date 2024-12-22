import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] num = new int[10001];
        
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine().trim());
            num[value]++;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<num.length;i++){
            for(int j=0;j<num[i];j++){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}