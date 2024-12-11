import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int n = Integer.parseInt(sc.nextLine());
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] numbers = new int[n];

        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        //System.out.println("clear");

        int cnt = 0;

        int start = 0;
        int end = n-1;
        int sum = numbers[start]+numbers[end];

        while(start<end){
            sum = numbers[start]+numbers[end];
            if(sum==m){
                cnt++;
                end--;
                start++;
            }
            else if(sum>m){
                end--;
            }
            else{
                start++;
            }
        }

        System.out.println(cnt);

    }
}