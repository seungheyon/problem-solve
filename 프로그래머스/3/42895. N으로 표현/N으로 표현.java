import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        
        for(int i=1;i<=8;i++){
            if(i>1){
                Set<Integer> newSet = new HashSet<>();
                int nn = N;
                for(int j=1;j<i;j++){
                    nn = nn*10 + N;
                }
                newSet.add(nn);
                for(int j=1;j<i;j++){
                    for(int op1 : dp.get(j)){
                        for(int op2 : dp.get(i-j)){
                            newSet.add(op1 + op2);
                            newSet.add(op1 - op2);
                            newSet.add(op1 * op2);
                            if(op2!=0){
                                newSet.add(op1 / op2);
                            }
                        }
                    }
                }
                dp.add(newSet);
            }
            else{
                Set<Integer> newSet = new HashSet<>();
                newSet.add(N);
                dp.add(newSet);
            }
            
            if(dp.get(i).contains(number)){
                return i;
            }
        }
        
        
        return -1;
    }
    
}