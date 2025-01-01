import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> intSet = new TreeSet<>();
    static boolean found = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] narr = new int[n];
        for(int i=0;i<n;i++){
            narr[i] = Integer.parseInt(str[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] marr = new int[m];
        String[] str2 = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            marr[i] = Integer.parseInt(str2[i]);
        }

        Arrays.sort(narr);
        boolean found = false;
        int[] answer = new int[m];

        for(int i=0;i<m;i++){
            int end = n-1;
            int start = 0;

            while(start<=end){
                int mid = (end+start)/2;
                if(narr[mid]>marr[i]){
                    end = mid-1;;
                }
                else if(narr[mid]<marr[i]){
                    start = mid+1;
                }
                else{
                    found = true;
                    break;
                }
            }
            if (found) {
                answer[i] = 1;
                found = false;
            }
        }

        for(int ans : answer){
            System.out.println(ans);
        }
    }
}