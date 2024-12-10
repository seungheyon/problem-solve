import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double[] subjects = new double[n];
        double max = 0;
        for(int i=0;i<n;i++){
            subjects[i] = sc.nextInt();
            if(subjects[i]>max){
                max = subjects[i];
            }
        }

        double answer = 0;

        for(int i=0;i<n;i++){
            subjects[i] = subjects[i]*100/max;
            answer += subjects[i];
        }

        System.out.println(answer/n);
    }
}