import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

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
        int[] parent = new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i] = i;
        }

        for(int i=0;i<e;i++){
            String str = br.readLine();
            String[] strs = str.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);
            edges.add(new Edge(a, b, c));
            //mat[a-1][b-1] = c;
        }
        edges.sort(Comparator.comparingInt(edge -> edge.cost));

        int sum = 0;
        for(Edge edge : edges){
            if(getParent(parent, edge.from) == getParent(parent, edge.to)){
                continue;
            }
            sum+= edge.cost;
            unionParent(edge.from, edge.to, parent);
        }

        System.out.println(sum);

    }

    private static int getParent(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int a, int b, int[] parent){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
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