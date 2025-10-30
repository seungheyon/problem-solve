import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 1;
        
        Queue<String> que = new LinkedList<>();
        que.add(begin);
        Set<String> vSet = new HashSet<>();
        vSet.add(begin);
        
        while(!que.isEmpty()){
            int s = que.size();
            //System.out.println();
            //System.out.print("in que : ");
            for(int i=0;i<s;i++){
                String cur = que.poll();
                //System.out.print(cur+" ");
                for(String word : words){
                    if(isSimilar(cur, word, vSet)){
                        if(word.equals(target)){
                            return answer;
                        }
                        que.add(word);
                    }
                }
            }
            answer++;
            //System.out.println();
            //System.out.println(answer);
        }
        return 0;
    }
    
    private boolean isSimilar(String cur, String comparison, Set<String > vSet){
        int difCount = 0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)!=comparison.charAt(i)){
                difCount++;
            }
        }
        if(difCount==1&&!vSet.contains(comparison)){
            vSet.add(comparison);
            return true;
        }
        return false;
    }
}