import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        //int n = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(str[1]);
        String[] str = br.readLine().split("-");
        int n = str.length;
        int[] sums = new int[n];
        for(int i=0;i<n;i++){
            String[] nums = str[i].split("\\+");
            sums[i] = 0;
            for(String sum : nums){
                sums[i]+=Integer.parseInt(sum);
            }
        }
        int answer = sums[0];
        for(int i=1;i<n;i++){
            answer-=sums[i];
        }

        System.out.println(answer);

    }
}