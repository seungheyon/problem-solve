class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int longSide = 0;
        int shortSide = 0;
        
        for(int[] size : sizes){
            if(size[0]>=size[1]){
                if(longSide<size[0]){
                    longSide = size[0];
                }
                if(shortSide<size[1]){
                    shortSide = size[1];
                }
            }
            else{
                if(longSide<size[1]){
                    longSide = size[1];
                }
                if(shortSide<size[0]){
                    shortSide = size[0];
                }
            }
        }
        
        answer = longSide*shortSide;
        
        return answer;
    }
}