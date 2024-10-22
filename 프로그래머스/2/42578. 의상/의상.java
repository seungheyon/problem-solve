import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> clothesMap = new HashMap<>();
        
        for(String[] cloth : clothes){
            if(clothesMap.containsKey(cloth[1])){
                clothesMap.put(cloth[1], clothesMap.get(cloth[1]) + 1);
                    continue;
            }
            clothesMap.put(cloth[1], 1);
        }
        
        for(String key : clothesMap.keySet()){
            answer = answer * (clothesMap.get(key) + 1);
        }
        
        return answer-1;
    }
}