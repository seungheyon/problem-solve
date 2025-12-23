import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int idx = score.length;
        
        while(idx-m>=0){
            //System.out.println(idx);
            answer +=score[idx-m]*m;
            //System.out.println("added score : "+score[idx-m]*m);
            idx-=m;
        }
        
        return answer;
    }
}