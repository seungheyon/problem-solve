class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] v = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!v[i]){
                v[i] = true;
                dfs(computers, n, i, v);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, int n, int cur, boolean[] v){
        for(int i=0;i<n;i++){
            if(computers[cur][i]>0){
                if(!v[i]){
                    v[i] = true;
                    dfs(computers, n, i, v);
                }
            }
        }
    }
}