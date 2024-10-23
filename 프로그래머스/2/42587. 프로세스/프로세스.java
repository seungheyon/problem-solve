import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> processQ = new LinkedList<>();
        Queue<Integer> locationQ = new LinkedList<>();
        
        int order = 0;
        for(Integer jobs : priorities){
            processQ.add(jobs);
            if(order==location){
                locationQ.add(1);
            }
            else{
                locationQ.add(0);
            }
            order++;
        }
        
        Integer job;
        Integer loc;
        int excuteCnt = 0;
        Boolean continueflag = false;
        while(!processQ.isEmpty()){
            job = processQ.poll();
            loc = locationQ.poll();
            for(Integer priority : processQ){
                if(priority>job){
                    processQ.add(job);
                    locationQ.add(loc);
                    continueflag = true;
                    break;
                }
            }
            if(continueflag){
                continueflag = false;
                continue;
            }
            excuteCnt ++;
            if(loc>0){
                answer = excuteCnt;
            }
        }
        
        return answer;
    }
}