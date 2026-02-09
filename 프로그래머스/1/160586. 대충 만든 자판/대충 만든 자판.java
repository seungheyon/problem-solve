import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> letterMap = new HashMap<>();
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                char cur = keymap[i].charAt(j);
                if(letterMap.containsKey(cur)){
                    if(letterMap.get(cur)>j){
                        letterMap.put(cur, j+1);
                    }
                    continue;
                }
                letterMap.put(cur, j+1);
            }
        }
        
        for(int i=0;i<targets.length;i++){
            for(int j=0;j<targets[i].length();j++){
                char cur = targets[i].charAt(j);
                if(letterMap.containsKey(cur)){
                    answer[i]+=letterMap.get(cur);
                    continue;
                }
                answer[i] = -1;
                break;
            }
        }
        
        //System.out.println(letterMap);
        
        return answer;
    }
}