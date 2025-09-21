import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 1;
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{0, 0});
        
        maps[0][0] = 0;
        
        while(!que.isEmpty()){
            
            int s = que.size();
            
            for(int i=0;i<s;i++){
                int[] cur = que.poll();
            
                if(cur[0]==maps.length-1&&cur[1]==maps[0].length-1){
                    // 도착
                    return answer;
                }
                if(cur[0]<maps.length-1&&maps[cur[0]+1][cur[1]]>0){
                    maps[cur[0]+1][cur[1]] = 0;
                    que.add(new int[]{cur[0]+1, cur[1]});
                }
                if(cur[1]<maps[0].length-1&&maps[cur[0]][cur[1]+1]>0){
                    maps[cur[0]][cur[1]+1] = 0;
                    que.add(new int[]{cur[0], cur[1]+1});
                }
                if(cur[0]>0&&maps[cur[0]-1][cur[1]]>0){
                    maps[cur[0]-1][cur[1]] = 0;
                    que.add(new int[]{cur[0]-1, cur[1]});
                }
                if(cur[1]>0&&maps[cur[0]][cur[1]-1]>0){
                    maps[cur[0]][cur[1]-1] = 0;
                    que.add(new int[]{cur[0], cur[1]-1});
                }
            }
            answer++;
        }
        
        return -1;
    }
}