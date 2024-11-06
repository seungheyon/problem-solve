class Solution {
    private int maxDepth = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] explored = new boolean[dungeons.length];
        
        search(0,k,dungeons, explored);
        
        return maxDepth;
    }
    
    private void search(int depth, int p, int[][] dungeons, boolean[] explored){
        
        maxDepth = Math.max(maxDepth, depth);
        
        for(int i=0; i<dungeons.length;i++){
            if(dungeons[i][0]<=p && !explored[i]){
                explored[i] = true;
                search(depth + 1, p - dungeons[i][1], dungeons, explored);
                explored[i] = false;
            }
        }
    }
}