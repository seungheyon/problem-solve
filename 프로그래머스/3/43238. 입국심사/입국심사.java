import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long end = (long)times[times.length-1]*n;
        long start = 0;
        long p = 0;
        
        boolean curved = false;
        
        while(start<=end){
            long mid = (start + end)/2;
            p = 0;
            for(int i=0;i<times.length;i++){
                p += mid/times[i];
            }
            if(p<n){
                start = mid+1;
            }
            else{
                
                answer = mid;
                end = mid-1;
            }
        }
        return answer;
    }
}