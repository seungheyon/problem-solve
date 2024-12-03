import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        //List<Integer> terms = new LinkedList<>();
        Arrays.sort(rocks);
        //boolean[] removed = new boolean[rocks.length];
        int removeCnt = 0;
        
        
        int end = distance;
        int start = 0;
        
        while(start<=end){
            int mid = (start + end)/2;
            // int before = 0;
            // int after = 1;
            removeCnt = 0;
            int prev = 0;
            //Arrays.fill(removed, false);
            for(int i=0;i<rocks.length;i++){
                
                if(rocks[i]-prev<mid){
                    removeCnt++;
                    continue;
                }
                prev = rocks[i];
                // 거리의 최솟값(mid)을 기준으로 바위를 제거
                // if(removed>=n){
                //     break;
                // }
                
                // before = 1;
                // after = 1;
                // while(true){
                //     if(i-before<0){
                //         break;
                //     }
                //     if(!removed[i-before]){
                //         break;
                //     }
                //     before++;
                // }
                // while(true){
                //     if(i+after==rocks.length){
                //         break;
                //     }
                //     if(!removed[i+after]){
                //         break;
                //     }
                //     after++;
                // }
                
                
                // if(i-before<=0){
                //     if(rocks[i]<mid){
                //         removed[i] = true;
                //         removeCnt++;
                //     }
                // }
                // else if(i+after==rocks.length){
                //     if(distance-rocks[i]<mid||rocks[i]-rocks[i-before]<mid){
                //         removed[i] = true;
                //         removeCnt++;
                //     }
                // }
                // else{
                //     if(rocks[i]-rocks[i-before]<mid){
                //         removed[i] = true;
                //         removeCnt++;
                //     }
                // }
            }
            if(distance-prev<mid){
                removeCnt++;
            }
            
//             int min = distance;
//             int bef = 0;
//             for(int i=0;i<rocks.length;i++){
//                 if(removed[i]){
//                     bef++;
//                     continue;
//                 }
//                 // before = 1;
                
//                 // while(true){
//                 //     if(i-before<0){
//                 //         break;
//                 //     }
//                 //     if(remove[i-before]){
//                 //         break;
//                 //     }
//                 //     before++;
//                 // }
//                 after = 1;
//                 while(true){
//                     if(i+after==rocks.length){
//                         break;
//                     }
//                     if(remove[i+after]){
//                         break;
//                     }
//                     after++;
//                 }
//                 if(i-bef==0){
//                     min = rocks[i];
//                 }
//                 else if(i+after==rocks.length){
//                     if(rocks[i]-rocks[i-bef]<min){
//                         min = rocks[i]-rocks[i-bef];
//                     }
//                     if(distance-rocks[i]<min){
//                         min = distance-rocks[i];
//                     }
//                 }
//                 else{
//                     if(rocks[i]-rocks[i-bef]<min){
//                         min = rocks[i]-rocks[i-bef];
//                     }
//                 }
//                 bef = 0;
//             }
            
            if(removeCnt>n){
                end = mid-1;
            }
            else{
                start = mid+1;
                answer = mid;
            }
            
        }
        return answer;
    }
}