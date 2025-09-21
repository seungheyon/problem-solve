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
    
    private void dfs(int start, int[][] computers, boolean[] visits){
        
        for(int i=0;i<computers.length;i++){
            if(computers[start][i]==1&&!visits[i]){
                visits[i] = true;
                dfs(i, computers, visits);
            }
        }
    }
}