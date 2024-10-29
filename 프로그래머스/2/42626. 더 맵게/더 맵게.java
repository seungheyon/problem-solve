import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        for(int scov : scoville){
            minheap.add(scov);
        }
        
        int shakeCount = 0;
        while(minheap.peek()<K){
            if(minheap.size()<2){
                return -1;
            }
            int newScov = minheap.poll() + minheap.poll()*2;
            minheap.add(newScov);
            shakeCount++;
        }
        
        
        return shakeCount;
    }
}