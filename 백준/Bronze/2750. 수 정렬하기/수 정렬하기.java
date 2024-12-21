import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int n = Integer.parseInt(sc.nextLine());
        int n = sc.nextInt();
        //int m = sc.nextInt();
        //sc.nextLine();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();

        }
        Arrays.sort(num);

        for(int number : num){
            System.out.println(number);
        }
    }
}