import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> intSet = new TreeSet<>();
    static boolean found = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int v = Integer.parseInt(str[2]);
        int[][] num = new int[m][2];

        Map<Integer, List<Integer>> intMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            intMap.put(i, new LinkedList<>());
        }

        for(int i=0;i<m;i++){
            String[] str2 = br.readLine().split(" ");
            num[i][0] = Integer.parseInt(str2[0]);
            num[i][1] = Integer.parseInt(str2[1]);
            intMap.get(num[i][0]).add(num[i][1]);
            intMap.get(num[i][1]).add(num[i][0]);
        }
        for(int nu : intMap.keySet()){
            intMap.get(nu).sort(null);
        }
        boolean[] visit = new boolean[n+1];

        dfs(v, intMap, visit);
        for(int i=0;i<=n;i++){
            visit[i] = false;
        }
        System.out.println("");
        bfs(v, intMap, visit);

    }

    private static void dfs(int n, Map<Integer, List<Integer>> intMap, boolean[] visited){
        visited[n] = true;
        System.out.print(n+" ");

        for(Integer i : intMap.get(n)){
            if(!visited[i]){
                dfs(i, intMap, visited);
            }
        }
    }


    private static void bfs(int n, Map<Integer, List<Integer>> intMap, boolean[] visited){
        visited[n] = true;
        Queue<Integer> que = new LinkedList<>();
        System.out.print(n+" ");
        que.add(n);
        while(!que.isEmpty()){
           int i = que.peek();
           for(int node : intMap.get(i)){
               if(!visited[node]){
                   visited[node] = true;
                   System.out.print(node+" ");
                   que.add(node);
               }
           }
           que.poll();
        }
    }
}
