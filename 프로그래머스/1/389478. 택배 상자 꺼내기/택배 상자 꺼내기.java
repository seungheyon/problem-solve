class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int h = (n-1)/w + 1;
        int[][] box = new int[h][w];
        
        int cur = 1;
        int idx = -1;
//         for(int i=0;i<h;i++){
//             for(int j=0;j<w;j++){
//                 if(idx>=0){
//                     if(j==idx){
//                         answer++;
//                     }
//                 }
//                 if(cur==num){
//                     idx = j;
//                 }
//                 if(i%2==0){
//                     box[i][j]=cur;
//                 }
//                 else{
//                     box[i][w-1-j]=cur;
//                 }
//                 if(cur==n){
//                     return answer;
//                 }
//                 cur++;
                
//             }
//         }
        
        
        for(int i=0;i<h;i++){
            if(i%2==0){
                for(int j=0;j<w;j++){
                    if(idx>=0){
                        if(j==idx){
                            answer++;
                        }
                    }
                    if(cur==num){
                        idx = j;
                    }
                    if(cur==n){
                        return answer;
                    }
                    cur++;
                }
            }
            else{
                for(int j=w-1;j>=0;j--){
                    if(idx>=0){
                        if(j==idx){
                            answer++;
                        }
                    }
                    if(cur==num){
                        idx = j;
                    }
                    if(cur==n){
                        return answer;
                    }
                    cur++;
                }
            }
        }
        
        return answer;
    }
}