import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        List<String> answerList = new ArrayList<>();
        //String[] answer = {};
        answerList.add("ICN");
        
        Map<String, List<String>> map = new HashMap<>();
        for(String[] ticket: tickets){
            if(map.containsKey(ticket[0])){
                map.get(ticket[0]).add(ticket[1]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                map.put(ticket[0], list);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        dfs2("ICN", map, answerList, tickets.length+1);
        String[] answer = answerList.toArray(new String[answerList.size()]);
        
        return answer;
    }
    
    private void dfs(String start, Map<String, List<String>> map, List<String> answerList, int goal){
        if(answerList.size()==goal){
            return;
        }
        if(!map.containsKey(start)){
            answerList.remove(answerList.size()-1);
            //ansCnt--;
            map.get(answerList.get(answerList.size()-1)).add(0, start);
            // if(map.get(answerList.get(answerList.size()-1)).higher(start)==null){
            //     return;
            // }
            //String higher = map.get(answerList.get(answerList.size()-1)).get(1);
            String higher = null;
            int idx = 0;
            List<String> curList = map.get(answerList.get(answerList.size()-1));
            for(int i=0;i<curList.size();i++){
                //System.out.println(curList.get(i));
                //System.out.println(start.compareTo(curList.get(i)));
                if(start.compareTo(curList.get(i))<0){
                    higher = curList.get(i);
                    idx = i;
                    map.get(answerList.get(answerList.size()-1)).remove(idx);
                    answerList.add(higher);
                    dfs(higher, map, answerList, goal);
                }
            }
            // if(higher==null){
            //     //System.out.println("out");
            //     return;
            // }
            return;
        }
        String dest = map.get(answerList.get(answerList.size()-1)).get(0);
        map.get(answerList.get(answerList.size()-1)).remove(0);
        answerList.add(dest);
        dfs(dest, map, answerList, goal);
    }
    
    private boolean dfs2(String start, Map<String, List<String>> map, List<String> answerList, int goal){
        if(answerList.size()==goal){
            return true;
        }
        if(!map.containsKey(start)){
            return false;
        }
        List<String> curList = map.get(start);
        for(int i=0;i<curList.size();i++){
            String cur = curList.get(i);
            map.get(start).remove(i);
            answerList.add(cur);
            if(dfs2(cur, map, answerList, goal)){
                return true;
            }
            map.get(start).add(i,cur);
            answerList.remove(answerList.size()-1);
        }
        return false;
    }
}