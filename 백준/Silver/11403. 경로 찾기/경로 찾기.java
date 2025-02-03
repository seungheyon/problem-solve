import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //int m = Integer.parseInt(br.readLine());

        int[][] mat = new int[n][n];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] strs = str.split(" ");
            for(int j=0;j<n;j++){
                mat[i][j] = Integer.parseInt(strs[j]);
                if(mat[i][j] == 0){
                    mat[i][j] = 100;
                }
            }
        }



        int[][] result = floyd_ws(mat, n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(result[i][j]>0&&result[i][j]<100){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(0+" ");
                }
                //System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
    private static int[][] floyd_ws(int[][] dist, int n){

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}