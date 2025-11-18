import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        Set<Integer> startSet = new HashSet<>();
        startSet.add(N);
        dp.add(new HashSet<>());
        dp.add(startSet);
        if(N==number){
            return 1;
        }
        
        for(int i=2;i<=8;i++){
            Set<Integer> curSet = new HashSet<>();
            int nn = N;
            for(int j=1;j<i;j++){
                nn = nn*10+N;
            }
            curSet.add(nn);
            for(int j=1;j<i;j++){
                for(int op1 : dp.get(j)){
                    for(int op2 : dp.get(i-j)){
                        curSet.add(op1+op2);
                        curSet.add(op1-op2);
                        curSet.add(op1*op2);
                        if(op2!=0){
                            curSet.add(op1/op2);
                        }
                    }
                }
            }
            if(curSet.contains(number)){
                return i;
            }
            dp.add(curSet);
        }
        return answer;
    }
}