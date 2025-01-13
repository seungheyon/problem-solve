import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        //int n = Integer.parseInt(br.readLine());
        double min = Double.parseDouble(str[0]);
        double max = Double.parseDouble(str[1]);
        
        int size = (int)(max-min);
        boolean[] isPowers = new boolean[size+1];
        Arrays.fill(isPowers, true);
        for(long j=2;j<=1000000;j++){
//
            long div = (long) Math.ceil(min/(j*j));
            for(long i = div*j*j;i<=max;i+=j*j){
                if(isPowers[(int)(i-min)]){
                    isPowers[(int)(i-min)] = false;
                }
            }
        }

        int cnt = 0;
        for(boolean pows: isPowers){
            if(pows){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    
}