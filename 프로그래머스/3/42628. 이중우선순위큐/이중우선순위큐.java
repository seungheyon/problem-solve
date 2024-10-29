import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(String opr : operations){
            if(opr.substring(0,1).equals("I")){
                int num = Integer.parseInt(opr.split(" ")[1]);
                //System.out.println(opr);
                minheap.add(num);
                maxheap.add(num);
            }
            else if(opr.split(" ")[1].equals("1") && !minheap.isEmpty() && !maxheap.isEmpty()){
                if(maxheap.peek() == minheap.peek()){
                    maxheap.clear();
                    minheap.clear();
                    continue;
                }
                //System.out.println(maxheap);
                minheap.remove(maxheap.poll());
                
            }
            else if(opr.split(" ")[1].equals("-1") && !minheap.isEmpty() && !maxheap.isEmpty()){
                if(maxheap.peek() == minheap.peek()){
                    maxheap.clear();
                    minheap.clear();
                    continue;
                }
                maxheap.remove(minheap.poll());
            }
        }
        if(!minheap.isEmpty()){
            answer[0] = maxheap.poll();
            answer[1] = minheap.poll();
        }
        
        return answer;
    }
}