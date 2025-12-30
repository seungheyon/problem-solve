//import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1;i<=number;i++){
            int curys = 0;
            for(int j=1;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    curys+=2;
                    if(j*j==i){
                        curys--;
                    }
                }
            }
            if(curys>limit){
                answer+=power;
            }
            else{
                answer+=curys;
            }
        }
        
        return answer;
    }
}