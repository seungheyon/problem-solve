import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<int[]> bridges = new ArrayList<>();
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        int[] cycleTable = new int[n];
        for(int i=0;i<n;i++){
            cycleTable[i] = i;
        }
        
        for(int[] cost : costs){
            if(getParent(cycleTable, cost[0])==getParent(cycleTable, cost[1])){
                continue;
            }
            // 현재 다리를 추가
            answer += cost[2];
            putTable1(cycleTable, cost);
            
        }
        return answer;
    }
    
    private void putTable1(int[] cycleTable, int[] cost){
        int a = getParent(cycleTable, cycleTable[cost[0]]);
        int b = getParent(cycleTable, cycleTable[cost[1]]);
        if(a<b){
            cycleTable[b] = a;
        }
        else{
            cycleTable[a] = b;
        }
    }
    
    private void putTable(int[] cycleTable, int rootA, int rootB){
        // if(cost[0]<cost[1]){
        //     cycleTable[cost[1]] = getParent(cycleTable, cycleTable[cost[0]]);
        // }
        // cycleTable[cost[0]] = getParent(cycleTable, cycleTable[cost[1]]);
        
    }
    
    private int getParent(int[] cycleTable, int n){
        if(cycleTable[n]==n){
            return n;
        }
        return cycleTable[n] = getParent(cycleTable, cycleTable[n]);
    }
}