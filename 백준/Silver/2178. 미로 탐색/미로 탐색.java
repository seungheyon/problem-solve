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
        int[][] arr = new int[n][m];

        //Map<Integer, List<Integer>> intMap = new HashMap<>();
//        for (int i = 1; i <= n; i++) {
//            intMap.put(i, new LinkedList<>());
//        }
        for(int i=0;i<n;i++){
            String[] str2 = br.readLine().split("");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(str2[j]);
            }
        }

        int answer = bfsMatrixMinPath(arr);
        System.out.println(answer);

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

    private static int bfsMatrixMinPath(int[][] maps){
        Queue<int[]> que = new LinkedList<>();
        int[] a = {0,0};

        int cnt = 1;
        que.add(a);
        while(!que.isEmpty()){
            int s = que.size();
            for(int i=0;i<s;i++){
                int[] cur = que.poll();
                if(cur[0]==maps.length-1&&cur[1]==maps[0].length-1){
                    return cnt;
                }
                if(cur[0]<maps.length-1&&maps[cur[0]+1][cur[1]]>0){
                    maps[cur[0]+1][cur[1]] = 0;
                    que.add(new int[] {cur[0]+1, cur[1]});
                }
                if(cur[1]<maps[0].length-1&&maps[cur[0]][cur[1]+1]>0){
                    maps[cur[0]][cur[1]+1] = 0;
                    que.add(new int[] {cur[0], cur[1]+1});
                }
                if(cur[0]>0&&maps[cur[0]-1][cur[1]]>0){
                    maps[cur[0]-1][cur[1]] = 0;
                    que.add(new int[] {cur[0]-1, cur[1]});
                }
                if(cur[1]>0&&maps[cur[0]][cur[1]-1]>0){
                    maps[cur[0]][cur[1]-1] = 0;
                    que.add(new int[] {cur[0], cur[1]-1});
                }
            }
            cnt++;
        }

        return 0;
    }
}