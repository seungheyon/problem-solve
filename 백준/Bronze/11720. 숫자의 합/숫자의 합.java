import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String numbers = sc.nextLine();

        int answer = 0;

        for(int i=0;i<n;i++){
            answer += Integer.parseInt(numbers.substring(i,i+1));
        }

        System.out.println(answer);
    }
}
