import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cam = -30000;
        for(int[] route : routes){
            if(route[0]>cam){
                cam = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}