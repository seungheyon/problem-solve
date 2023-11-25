import java.util.Arrays;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long Fsum = Arrays.stream(queue1).sum();
        long Ssum = Arrays.stream(queue2).sum();

        long mid = (Fsum+Ssum)/2;

        int length = queue1.length;
        int[] queue = new int[length*2];
        for(int i=0;i<length;i++){
            queue[i] = queue1[i];
            queue[i+length] = queue2[i];
        }

        int p1 = 0;
        int p2 = length;
        
        while(true){
            if(answer>length*4){
                answer = -1;
                break;
            }
            if(Fsum == Ssum){
                break;
            }
            if(Fsum>mid){
                Fsum -=queue[p1];
                Ssum +=queue[p1];
                p1 = (p1 + 1)%(length*2);
                
                answer++;
                continue;
            }
            if(Ssum>mid){
                Fsum +=queue[p2];
                Ssum -=queue[p2];
                p2  = (p2 + 1)%(length*2);
                
                answer++;
                continue;
            }
        }
        
        return answer;
    }
}