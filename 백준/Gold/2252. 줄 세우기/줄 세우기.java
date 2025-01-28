import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] inDegree = new int[n+1];
        Map<Integer, List<Integer>> eMap = new HashMap<>();
        for(int i=0;i<m;i++){
            String[] str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            inDegree[b]++;
            if(!eMap.containsKey(a)){
                List<Integer> list = new ArrayList<>();
                list.add(b);
                eMap.put(a,list);
                continue;
            }
            eMap.get(a).add(b);
        }

        int[] result = topology_sort(n, inDegree, eMap);

        for(int el : result){
            System.out.print(el+" ");
        }
    }
    
    private static int[] topology_sort(int n, int[] inDegree, Map<Integer, List<Integer>> eMap) {
        int[] result = new int[n];
        Queue<Integer> que = new LinkedList<>();
        // 진입차수 0인 노드 삽입
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                que.add(i);
            }
        }

        for(int i=0;i<n;i++){
            if(que.isEmpty()){ // cycle detected
                System.out.println("cycle detected");
                return result;
            }
            int x = que.peek();
            // 큐에서 꺼낸 노드 result[] 에 저장
            result[i] = x;
            que.poll();
            // 큐에서 꺼낸 노드의 간선 제거
            if(eMap.containsKey(x)){
                for(int e : eMap.get(x)){
                    inDegree[e]--;
                    // 새롭게 진입차수가 0이 된 노드를 que 에 삽입
                    if(inDegree[e]==0){
                        que.add(e);
                    }
                }
            }
        }
        return result;
    }
}