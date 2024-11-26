class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visits = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visits[i]){
                visits[i] = true;
                answer++;
                dfs(i, computers, visits);
            }
        }
        
        return answer;
    }
    
    private void dfs(int i, int[][] computers, boolean[] visits){
        for(int j=0;j<computers.length;j++){
            if(computers[i][j]>0&&!visits[j]){
                visits[j] = true;
                dfs(j, computers, visits);
            }
        }
    }
}