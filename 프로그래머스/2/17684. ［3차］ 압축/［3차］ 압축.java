import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<Integer>();
        String[] dicArr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Map<String, Integer> dic = new HashMap<>();
        for(int i=0;i< dicArr.length;i++){
            dic.put(dicArr[i],i+1);
        }

        while(true){
            int i = 0;

            if(msg.length()==1){
                answer.add(dic.get(msg));
                break;
            }
            while(dic.containsKey(msg.substring(0,i+1))){
                i++;
                if(msg.length()==i){
                    answer.add(dic.get(msg.substring(0,i)));
                    return answer.stream().mapToInt(Integer::intValue).toArray();
                }
            }
            answer.add(dic.get(msg.substring(0,i)));
            dic.put(msg.substring(0,i+1),dic.size()+1);
            msg = msg.substring(i);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}