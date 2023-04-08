import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer>marathone = new HashMap<>();
        for(String name:participant){
            if(marathone.containsKey(name)){
                // 변수로 주어진 key 값으로 value 값을 가져와서 1을 더하는 코드
                marathone.replace(name, marathone.get(name)+1);
            }
            else {
                marathone.put(name, 1);
            }
        }

        for(String name:completion){
            marathone.replace(name, marathone.get(name)-1);
        }

        for(String name:participant){
            if(marathone.get(name)==1){
                answer = name;
            }
        }
        return answer;
    }
}