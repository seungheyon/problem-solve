import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

//        int[][] mat = new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i==j){
//                    mat[i][j] = 0;
//                    continue;
//                }
//                mat[i][j] = 10000000;
//            }
//        }

        List<Edge> edges = new ArrayList<>();

        for(int i=0;i<m;i++){
            String str = br.readLine();
            String[] strs = str.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);
            edges.add(new Edge(a, b, c));
            //mat[a-1][b-1] = c;
        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(mat[i][j]+" ");
//            }
//            System.out.println();
//        }




        long[] result = bellman_ford(n, edges, 1);
        if(result==null){
            System.out.println(-1);
            return;
        }

        for(int i=2;i<=n;i++){
            if(result[i]==100000000){
                System.out.println(-1);
                continue;
            }
            System.out.println(result[i]);
        }

    }
    
    private static long[] bellman_ford(int n, List<Edge> edges, int start){
        long[] dist = new long[n+1];
        int inf = 100000000;
        Arrays.fill(dist, inf);
        dist[start] = 0;

        for(int i=1;i<n;i++){
            for(Edge edge : edges){
                if(dist[edge.from]!=inf && dist[edge.from]+edge.cost < dist[edge.to]){
                    dist[edge.to] = dist[edge.from]+edge.cost;
                }
            }
        }

        for(Edge edge : edges){
            if(dist[edge.from]!=inf && dist[edge.from]+edge.cost < dist[edge.to]){
               // 음수간선 사이클 탐지
                return null;
            }
        }

        return dist;
    }

}

class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}