import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;
        int start = 1;
        int end = 1;
        int sum = 1;
        //System.out.println(n);
        for(int i=1;i<=n;i++){
            while(sum<n){
                end++;
                sum += end;
            }
            if(sum==n){
                cnt++;
            }
            sum -= start;
            start++;
        }

        System.out.println(cnt);

    }
}