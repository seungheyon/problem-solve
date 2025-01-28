import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //String[] str = br.readLine().split(" ");
        //int n = Integer.parseInt(str[0]);
        //int m = Integer.parseInt(str[1]);

        int[] inDegree = new int[n+1];
        Map<Integer, List<Integer>> eMap = new HashMap<>();
        int[] time = new int[n+1];
        for(int i=1;i<=n;i++){
            String[] str2 = br.readLine().split(" ");
            int b = Integer.parseInt(str2[0]);
            time[i] = b;

            for(int j=1;j< str2.length-1;j++){
                inDegree[i]++;
                int a = Integer.parseInt(str2[j]);
                if(!eMap.containsKey(a)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    eMap.put(a,list);
                    continue;
                }
                eMap.get(a).add(i);
            }
        }

        int[] result = topology_time(n, inDegree, eMap, time);


        for(int i=1;i<=n;i++){
            System.out.println(result[i]);
        }
    }
    
    private static int[] topology_time(int n, int[] inDegree, Map<Integer, List<Integer>> eMap, int[] time) {
        int[][] result = new int[n][2];
        Queue<Integer> que = new LinkedList<>();
        int[] time_before = new int[n+1];
        // 진입차수 0인 노드 삽입
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                que.add(i);
                time_before[i] = time[i];
            }
        }

        for(int i=0;i<n;i++){
            if(que.isEmpty()){ // cycle detected
                System.out.println("cycle detected");
                return time_before;
            }
            int x = que.peek();
            // 큐에서 꺼낸 노드 result[] 에 저장
            result[i][0] = x;
            que.poll();
            // 큐에서 꺼낸 노드의 간선 제거
            if(eMap.containsKey(x)){
                for(int e : eMap.get(x)){
                    time_before[e] = Math.max(time_before[e], time_before[x]);
                    inDegree[e]--;
                    // 새롭게 진입차수가 0이 된 노드를 que 에 삽입
                    if(inDegree[e]==0){
                        que.add(e);
                        time_before[e] = time_before[e] + time[e];
                    }
                }
            }
        }
        for(int[] res : result){
            res[1] = time_before[res[0]];
        }

        return time_before;
    }
}