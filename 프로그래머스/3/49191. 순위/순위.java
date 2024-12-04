import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] records = new boolean[n+1][n+1];
        // Map<Integer, List<Integer>> wins = new HashMap<>();
        // Map<Integer, List<Integer>> loose = new HashMap<>();
        
        for(int[] result : results){
            // if(wins.containsKey(results[0])){
            //     wins.get(results[0]).add(results[1]);
            // }
            // else{
            //     List<Integer> list = new ArrayList<>();
            //     list.add(results[1]);
            //     wins.put(results[0], list);
            // }
            records[result[0]][result[1]] = true;
        }
        
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                if(records[i][k]){ // i는 k 를 거쳐간(이긴) 노드
                    for(int j=1;j<n+1;j++){
                        if(records[k][j]){ // j 는 k에게 진 노드
                            records[i][j] = true;
                        }
                    }
                }
            }
        }
        
        for(int k=1;k<n+1;k++){
            int cnt = 0;
            for(int i=1;i<n+1;i++){
                if(records[k][i]){
                    cnt++;
                }
                if(records[i][k]){
                    cnt++;
                }
            }
            if (cnt>=n-1){
                System.out.println(cnt);
                answer++;
            }
        }
        
        
        return answer;
    }
}