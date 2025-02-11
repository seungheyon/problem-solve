import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        int lansum = 0;
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            char[] chars = str.toCharArray();
            for(int j=0;j<n;j++){
                int length;
                if(Character.isUpperCase(chars[j])){
                    length = (int)(chars[j] - 38);
                }else if(Character.isLowerCase(chars[j])){
                    length = (int)(chars[j] - 96);
                }
                else{
                    //length = (int)(chars[j] - 48);
                    continue;
                }
                lansum += length;
                edges.add(new Edge(i, j+1, length));
            }

        }
        edges.sort(Comparator.comparingInt(edge -> edge.cost));

        int sum = 0;
        int cnt = 0;
        for(Edge edge : edges){
            if(getParent(parent, edge.from) == getParent(parent, edge.to)){
                continue;
            }
            sum+= edge.cost;
            cnt++;
            unionParent(edge.from, edge.to, parent);
        }

        int result = lansum - sum;
        if(cnt<n-1){
            result = -1;
        }

        System.out.println(result);

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