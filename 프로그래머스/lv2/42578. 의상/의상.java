import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> intMap = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            int getVal = 1;
            if(intMap.containsKey(clothes[i][1])){
                getVal = intMap.get(clothes[i][1])+1;
            }
            intMap.put(clothes[i][1],getVal);
        }

        Collection<Integer> values = intMap.values();

        for(int value:values){
            answer *= (value+1);
        }
        return answer-1;
    }
}