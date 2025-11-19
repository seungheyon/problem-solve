class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[] = new int[triangle.length];
        for(int i=0;i<triangle.length;i++){
            int[] cur = new int[i+1];
            for(int j=0;j<=i;j++){
                if(j==0){
                    cur[j]=dp[j]+triangle[i][j];
                    continue;
                }
                if(j==i){
                    cur[j]=dp[j-1]+triangle[i][j];
                    continue;
                }
                if(dp[j-1]<dp[j]){
                    cur[j]=dp[j]+triangle[i][j];
                }
                else{
                    cur[j]=dp[j-1]+triangle[i][j];
                }
            }
            for(int j=0;j<=i;j++){
                dp[j] = cur[j];
            }
        }
        int max = 0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        
        return max;
    }
}