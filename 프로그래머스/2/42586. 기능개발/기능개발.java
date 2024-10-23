import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> cdays = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        int a = 1;
        for(int i=0;i<progresses.length;i++){            
            while((progresses[i] + a * speeds[i])<100){
                a++;
            }
            cdays.add(a);
        }
        
        
        
        int deployDay = cdays.get(0);
        int deployCount = 0;
        int jobs = 0;
        for(int i=0;i<cdays.size();i++){
            
            if(cdays.get(i)>deployDay){
                //answer[deployCount]  = jobs;
                res.add(jobs);
                deployDay = cdays.get(i);
                deployCount++;
                jobs = 0;
            }            
            jobs ++;
        }
        //answer[deployCount]  = jobs;
        res.add(jobs);
        
        answer = res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        return answer;
    }
}