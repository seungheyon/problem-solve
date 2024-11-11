import java.util.*;
class Solution {
    public int solution(int n, int[] losts, int[] reserves) {
        int answer = n-losts.length;
        
        Map<Integer, Integer> lostMap = new HashMap<>();
        Arrays.sort(reserves);
        for(int lost : losts){
            lostMap.put(lost, lost);
        }
        
        for(int i=0;i<reserves.length;i++){
            if(lostMap.containsKey(reserves[i])){
                answer++;
                lostMap.remove(reserves[i]);
                continue;
            }
            if(lostMap.containsKey(reserves[i]-1)){
                if(i<reserves.length-1){
                    if(reserves[i+1]==reserves[i]-1){
                        continue;
                    }
                    // if(reserves[i-1]==reserves[i]-1){
                    //     continue;
                    // }
                }
                answer++;
                lostMap.remove(reserves[i]-1);
                continue;
            }
            if(lostMap.containsKey(reserves[i]+1)){
                if(i<reserves.length-1){
                    if(reserves[i+1]==reserves[i]+1){
                        continue;
                    }
                    // if(reserves[i-1]==reserves[i]+1){
                    //     continue;
                    // }
                }
                answer++;
                lostMap.remove(reserves[i]+1);
            }
        }
        
        return answer;
    }
}