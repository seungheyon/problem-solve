import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        //bfs 로 풀기
        
        Queue<Integer> que = new LinkedList<>();
        //List<List<Integer>> matrix = new ArrayList<>();
        Map<Integer, List<Integer>> matrix = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        
        
        for(int[] edge : edges){
            if(matrix.containsKey(edge[0])){
                matrix.get(edge[0]).add(edge[1]);
            }
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(edge[1]);
                matrix.put(edge[0], newList);
            }
            if(matrix.containsKey(edge[1])){
                matrix.get(edge[1]).add(edge[0]);
            }
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(edge[0]);
                matrix.put(edge[1], newList);
            }
        }
        
        que.add(1);
        visited[1] = true;
        int farNode = 0;
        while(!que.isEmpty()){
            int s = que.size();
            farNode = 0;
            for(int j=0;j<s;j++){
                int cur = que.poll();
                //System.out.println(cur);
                farNode++;
                
                for(int node : matrix.get(cur)){
                    if(!visited[node]){
                        que.add(node);
                        visited[node] = true;
                    }
                }
                // for(int i=1;i<n+1;i++){
                //     if(matrix[cur][i]==1&&!visited[i]){
                //         que.add(i);
                //         visited[i] = true;
                //     }
                // }
            }
            
        }
        
        
        return farNode;
    }
}