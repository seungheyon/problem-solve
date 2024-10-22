import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
               continue;
            }
            result.add(arr[i]);
        } 
        result.add(arr[arr.length-1]);
        
        answer = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        return answer;
    }
}
