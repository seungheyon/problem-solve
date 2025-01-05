import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        int sum = 0;
        int maxLect = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
            sum+=arr[i];
            if(arr[i]>maxLect){
                maxLect = arr[i];
            }
        }

        int ans = maxLect;
        int start = maxLect;
        int end = sum;

        while(start<=end){
            int mid = (start+end)/2;
            int diskNum = 0;
            int diskSum = 0;
            for(int i=0;i<n;i++){
                diskSum+= arr[i];
                if(diskSum>mid){
                    diskNum++;
                    diskSum = arr[i];
                }
            }
            diskNum++;
            if(diskNum>m){
                start = mid+1;
            }
            else{
                end = mid-1;
                ans = mid;
            }
        }
        System.out.println(ans);

    }
}