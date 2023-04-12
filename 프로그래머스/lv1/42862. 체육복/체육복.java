import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n-lost.length;
        int done = 0;
        Arrays.sort(reserve);
        Arrays.sort(lost);
        for(int i=0;i<reserve.length;i++){
            if(reserve[i]<0){
                continue;
            }
            for(int j=0;j<lost.length;j++){
                if(lost[j]<0){
                    continue;
                }
                if(reserve[i]==lost[j]){
                    answer++;
                    reserve[i] = -2;
                    lost[j] = -2;
                }
            }
        }
        for(int i=0;i<reserve.length;i++){
            if(reserve[i]<0){
                continue;
            }
            for(int j=0;j<lost.length;j++){
                if(lost[j]<0){
                    continue;
                }
                if(reserve[i]-1==lost[j]||reserve[i]+1==lost[j]){
                    answer++;
                    //done++;
                    lost[j]=-2;
                    //i++;
                    break;
                }
            }
        }
        return answer;
    }
}