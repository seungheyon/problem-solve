import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> smap = new HashMap<>();
        
        for(int i=0;i<name.length;i++){
            smap.put(name[i], yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++){
            int score = 0;
            for(String people: photo[i]){
                if(!smap.containsKey(people)){
                    continue;
                }
                score+=smap.get(people);
            }
            answer[i] = score;
        }
        
        return answer;
    }
}