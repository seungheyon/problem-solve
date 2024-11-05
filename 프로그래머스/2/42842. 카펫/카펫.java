class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int a = 3;a<brown;a++){
            if((brown + yellow)%a==0){
                if((brown + yellow)/a + a == (brown + 4)/2){
                    answer[0] = (brown + yellow)/a;
                    answer[1] = a;
                    return answer;
                }
            }
        }
        return answer;
    }
}