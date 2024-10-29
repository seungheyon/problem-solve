import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> requestQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> jobQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for( int[] job : jobs){
            requestQ.add(job);
        }
        int thSum = 0;
        int sec = 0;
        int currentJobFin = 0;
        while(true){
            if(!requestQ.isEmpty()){
                while(!requestQ.isEmpty() && requestQ.peek()[0]<=sec){
                    //requestQ.peek[0] = sec;
                    jobQ.add(requestQ.poll());
                }
            }
            if(sec>=currentJobFin){
                if(jobQ.isEmpty()){
                    if(requestQ.isEmpty()){
                        break;
                    }
                    sec ++;
                    currentJobFin ++;
                    continue;
                }
                //System.out.println("start : "+ currentJobFin + ", due : " + jobQ.peek()[1] + ", waitfrom " + jobQ.peek()[0]);
                thSum += currentJobFin + jobQ.peek()[1] - jobQ.peek()[0];
                
                currentJobFin = currentJobFin + jobQ.peek()[1];
                jobQ.poll();
                
            }
            
            sec ++;
        }
        //System.out.println(26/3);
        answer = thSum/jobs.length;
        
        return answer;
    }
}