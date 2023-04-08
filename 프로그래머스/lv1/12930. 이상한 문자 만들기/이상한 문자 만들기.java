class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ",-1);
        for(int k=0;k<words.length;k++){
            //System.out.println(words[k]);
            for(int i=0;i<words[k].length();i++){
                if(i%2==0){ // 짝수번째 인덱스
                    String temp = words[k].substring(i,i+1).toUpperCase();
                    //System.out.println(temp);
                    answer += temp;
                }
                else{
                    String temp = words[k].substring(i,i+1).toLowerCase();
                    answer += temp;
                }
            }
            if(k!= words.length-1){
                answer += " ";
            }
        }
        return answer;
    }
}