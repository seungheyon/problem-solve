import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    mat[i][j] = 0;
                    continue;
                }
                mat[i][j] = 100;
            }
        }

        for(int i=0;i<m;i++){
            String str = br.readLine();
            String[] strs = str.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            mat[a-1][b-1] = 1;
            mat[b-1][a-1] = 1;
        }



        int result = kevinBacon(mat, n);

        System.out.println(result);

    }
    private static int kevinBacon(int[][] dist, int n){

        int[] res = new int[n];
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int min = 10000;
        int midx = n;
        for(int i=n-1;i>=0;i--){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum += dist[i][j];
            }
            res[i] = sum;
            if(res[i]<=min){
                min = res[i];
                midx = i;
            }
        }

        return midx+1;
    }
}