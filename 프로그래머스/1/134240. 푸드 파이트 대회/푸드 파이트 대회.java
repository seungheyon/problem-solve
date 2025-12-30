class Solution {
    public String solution(int[] food) {
        
        StringBuilder result = new StringBuilder();
        
        addStr(result, food, 1);
        
        String answer = result.toString();
        
        System.out.println(answer);
        
        return answer;
    }
    private void addStr(StringBuilder str, int[] food, int idx){
        if(idx>=food.length){
            str.append("0");
            return;
        }
        int div = food[idx]/2;
        for(int i=0;i<div;i++){
            str.append(String.valueOf(idx));
        }
        addStr(str, food, idx+1);
        for(int i=0;i<div;i++){
            str.append(String.valueOf(idx));
        }
        return;
    }
}