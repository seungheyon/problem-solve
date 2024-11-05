import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        Map<String, Integer> numMap = new HashMap<>();
        
        for(int i=0;i<numbers.length();i++){
            String num = numbers.substring(i, i+1);
            if(numMap.containsKey(num)){
                numMap.put(num, numMap.get(num) + 1);
                continue;
            }
            numMap.put(num,1);
        }
        
        //numMap.forEach((key, value) -> System.out.println(key + " = " + value));
        
        int limit = (int)Math.pow(10, numbers.length());
        List<Integer> primes = generatePrimes(limit);
        
        Stack<String> numStack = new Stack<>();
        for(Integer prime : primes){
            // System.out.println(prime);
            String pnum = Integer.toString(prime);
            for(int i=0;i<pnum.length();i++){
                String num = pnum.substring(i, i+1);
                if(numMap.containsKey(num)){    // 해당 소수의 각 자리에 대응되는 카드가 있을 경우
                    // 카드를 하나씩 제거 -> stack 에 삽입
                    if(numMap.get(num)==1){
                        numMap.remove(num);
                    }
                    else{
                        numMap.put(num, numMap.get(num) - 1);
                    }
                    numStack.push(num);
                }
                else{
                    // 아닐경우 꺼낸 카드를 다시 회수(는 마지막에(탈출 후) 어차피 함)
                    // while(!numStack.isEmpty){
                    //     if(numMap.containsKey(numStack.peek())){
                    //         String number = numStack.pop();
                    //         numMap.put(number, numMap.get(number) + 1);
                    //     }
                    //     else{
                    //         numMap.put(numStack.pop(), 1);
                    //     }
                    // }
                    break;
                }
            }
            if(numStack.size()==pnum.length()){
                answer++;
                // System.out.println("find Prime!!!!!!!!!!!!!!!!!!!!!!!!!");
                // for(String elem: numStack){
                //     System.out.print(elem);   
                // }
                // System.out.println();
                // System.out.println();
            }
            while(!numStack.isEmpty()){
                if(numMap.containsKey(numStack.peek())){
                    String number = numStack.pop();
                    numMap.put(number, numMap.get(number) + 1);
                }
                else{
                    numMap.put(numStack.pop(), 1);
                }
            }
        }
        
        
        
        return answer;
    }
    
    
    public static List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}