import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<String, Integer> map = new HashMap<>();
        
        int idx = 0;
        
        while(idx<s.length()){
            
            String cur = s.substring(idx, idx+1);
            if(!map.containsKey(cur)){
                answer[idx] = -1;
            }
            else{
                answer[idx] = idx-map.get(cur);
            }
            map.put(cur, idx);
            idx++;
        }
        
        return answer;
    }
}