class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        int mod = 1000000007;
        //double routes = 0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==1&&j==1){
                    dp[i][j] = 1;
                    continue;
                }
                if(i==1){
                    dp[i][j] = dp[i][j-1];
                }
                if(j==1){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j])%mod;
                }
                for(int[] puddle : puddles){
                    if(puddle[0]==i&&puddle[1]==j){
                        dp[i][j] = 0;
                    }
                }
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        
        return dp[m][n];
    }
}