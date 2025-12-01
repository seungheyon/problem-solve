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
            }
            if(distance-prev<mid){
                removeCnt++;
            }
            
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