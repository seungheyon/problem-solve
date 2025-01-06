import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(str[1]);
        //String[] str = br.readLine().split(" ");
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); // Compare by second element
            } else {
                return Integer.compare(a[0], b[0]); // If equal, compare by first element
            }
        });

        int cur = 0;
        int hcnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i][0]>=cur){
                hcnt++;
                cur = arr[i][1];
            }
        }

        System.out.println(hcnt);

    }
}