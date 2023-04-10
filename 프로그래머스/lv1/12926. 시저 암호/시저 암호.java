class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            int intochar = 0;
            char appen = s.charAt(i);
            if(appen==' '){
                answer += appen;
                continue;
            }
            if((int)appen <= 90){
                intochar = (int)appen+n;
                if(intochar>90){
                    intochar = intochar%90 + 64;
                }
            }
            else if((int)appen >=97){
                intochar = (int)appen+n;
                if(intochar>122){
                    intochar = intochar%122 + 96;
                }
            }
            appen = (char)intochar;
            answer += appen;
        }
        return answer;
    }
}