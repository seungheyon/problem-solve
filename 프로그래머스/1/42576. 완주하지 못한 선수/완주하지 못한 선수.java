import java.util.*;
class Solution {
    public String solution(String[] participants, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<String, Integer>();
        for(String participant : participants){
            if(participantMap.containsKey(participant)){
                participantMap.put(participant, participantMap.get(participant) + 1);
            }
            else{
                participantMap.put(participant, 1);
            }
            
        }
        for(String completed : completion){
            participantMap.put(completed, participantMap.get(completed) -1);
        }
        for(String participant : participants){
            if(participantMap.get(participant)>0){
                return participant;
            }
        }
        return answer;
    }
}