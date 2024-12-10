import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int n = Integer.parseInt(sc.nextLine());
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] numbers = new int[n][n];
        int[][] sum = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                numbers[i][j] = sc.nextInt();
                if(i==0&&j==0){
                    sum[i][j] = numbers[i][j];
                    continue;
                }
                if(i==0){
                    sum[i][j] = sum[i][j-1] + numbers[i][j];
                    continue;
                }
                if(j==0){
                    sum[i][j] = sum[i-1][j] + numbers[i][j];
                    continue;
                }
                sum[i][j] = sum[i][j-1] + sum[i-1][j] -sum[i-1][j-1] + numbers[i][j];
            }
            sc.nextLine();
        }

        int x1, x2, y1, y2;
        int[] answer = new int[m];
        for(int k=0;k<m;k++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            x1--;x2--;y1--;y2--;
            if(x1==0&&y1==0){
                answer[k] = sum[x2][y2];
                continue;
            }
            if(x1==0){
                answer[k] = sum[x2][y2] - sum[x2][y1-1];
                continue;
            }
            if(y1==0){
                answer[k] = sum[x2][y2] - sum[x1-1][y2];
                continue;
            }
            answer[k] = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];

            sc.nextLine();
        }


        for(int k=0;k<m;k++){
            System.out.println(answer[k]);
        }

    }
}
