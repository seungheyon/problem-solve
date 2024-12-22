import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String numString = sc.nextLine();
        int[] num = new int[numString.length()];
        for(int i=0;i<numString.length();i++){
            num[i] = Integer.parseInt(numString.substring(i,i+1));
        }
        Arrays.sort(num);

        for (int i = numString.length()-1; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }
}
