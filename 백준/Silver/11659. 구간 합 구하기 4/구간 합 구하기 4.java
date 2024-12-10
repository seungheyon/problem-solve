import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int n = Integer.parseInt(sc.nextLine());
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] numbers = new int[n];
        int[] sum = new int[n];
        
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
            if(i==0){
                sum[i] = numbers[i];
                continue;
            }
            sum[i] = sum[i-1] + numbers[i]; 
             
        }

        int start;
        int end;
        int[] answer = new int[m];
        for(int k=0;k<m;k++){
            start = sc.nextInt();
            end = sc.nextInt();
            if(start==1){
                answer[k] = sum[end-1];
                continue;
            }
            answer[k] = sum[end-1] - sum[start-2];
        }
        
        for(int k=0;k<m;k++){
            System.out.println(answer[k]);
        }

    }
}