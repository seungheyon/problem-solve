import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<String> wordList = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        Set<String> v = new HashSet<>();
        
        for(String word : words){
            wordList.add(word);
        }
        
        que.add(begin);
        
        while(!que.isEmpty()){
            int s = que.size();
            for(int i=0;i<s;i++){
                if(findTarget(wordList, que, v, target)){
                    //System.out.println("out!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    return answer;
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    private boolean findTarget(List<String> words, Queue<String> que, Set<String> v, String target){
        String begin = que.poll();
        if(begin.equals(target)){
            return true;
        }
        for(String word : words){
            if(v.contains(word)){
                continue;
            }
            int diff = 0;
            for(int i=0;i<begin.length();i++){
                if(begin.charAt(i)!=word.charAt(i)){
                    diff++;
                }
                if(diff>1){
                    break;
                }
            }
            if(diff==1){
                que.add(word);
                v.add(word);
            }
        }
        // for(String q : que){
        //     System.out.print(q);
        //     System.out.print(" ");
        // }
        // System.out.println(" ");
        
        
        return false;
    }
}