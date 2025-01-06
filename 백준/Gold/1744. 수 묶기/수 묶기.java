import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(str[1]);
        //String[] str = br.readLine().split(" ");
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(n==1){
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);
//        if(n==2){
//            if(arr[0]*arr[1]>arr[1]){
//                System.out.println(arr[0]*arr[1]);
//                return;
//            }
//            System.out.println(arr[0]+arr[1]);
//            return;
//        }


        int sum = 0;
        int stopPoint = n;
        for(int i=n-1;i>0;i--){
            if(arr[i]*arr[i-1]>arr[i]){// -> arr[i]>arr[i-1]>1 인 경우
                if(arr[i-1]<0){// -> arr[i] 와 arr[i-1] 둘 다 음수일 경우 -> 다음 for문에서 처리
                    stopPoint = i+1;
                    break;
                }
                sum+=arr[i]*arr[i-1];
                stopPoint = i-1;
                i--;
                continue;
            }
            stopPoint = i;// arr[i]>=1이면서 arr[i-1]<1 인 경우 arr[i]는 arr[i-10]과 묶이지 않음 -> 다음 for 문에서 처리
            sum+=arr[i];// 일단 처리
            break;
        }
        //System.out.println("stopPoint : "+stopPoint);
        int stopPoint2 = -1;
        for(int i=0;i<stopPoint-1;i++){// 처리되지 않은 수열을 처리 -> 둘다 음수이거나 오른쪽 수가 0 또는 1 인 경우
            if(arr[i+1]<=0){
                sum+=arr[i]*arr[i+1];
                i++;
                stopPoint2 = i;
                continue;
            }
            // 오른쪽 수가 1인 경우 -> 1까지 sum에 추가하여 처리
            stopPoint2 = i;
            //System.out.println("여기 들어왔을때 sum : "+sum+" , i: "+i);
            sum+= arr[i];
            //sum+=arr[i+1];
        }
        if(stopPoint-stopPoint2>1){
            sum+=arr[stopPoint-1];
        }
        //System.out.println("stopPoint2 : "+stopPoint2);
        System.out.println(sum);

    }
}