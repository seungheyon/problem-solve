import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> waitQ = new LinkedList<>();
        
        Queue<Integer> bridgeQ = new LinkedList<>();
        Queue<Integer> inTimeQ = new LinkedList<>();
        
        int totalWeights = 0;
        int truckCnt = 0;
        
        for(int truck : truck_weights){
            waitQ.add(truck);
        }
        
        int sec = 0;
        while(true){
            if(!inTimeQ.isEmpty() && sec==bridge_length + inTimeQ.peek()){
                int truck = bridgeQ.poll();
                inTimeQ.poll();
                truckCnt--;
                totalWeights -= truck;
                System.out.print("out   ");
                System.out.println(sec);
            }
            
            if(!waitQ.isEmpty() && truckCnt<bridge_length && (totalWeights + waitQ.peek())<=weight){
                int truck = waitQ.poll();
                bridgeQ.add(truck);
                inTimeQ.add(sec);
                truckCnt++;
                totalWeights += truck;
                System.out.print("in   ");
                System.out.println(sec);
            }
            
            sec++;
            if(waitQ.isEmpty()&&bridgeQ.isEmpty()){
                    break;
            }
        }
        
        return sec;
    }
}