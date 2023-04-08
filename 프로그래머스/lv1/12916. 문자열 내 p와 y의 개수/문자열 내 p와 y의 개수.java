class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.        
        s = s.toLowerCase();
         int pn = 0;
        int yn = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'){
                pn++;
            }
            if(s.charAt(i)=='y'){
                yn++;
            }
        }
        if(pn!=yn){
            answer = false;
        }

        return answer;
    }
}