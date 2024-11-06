class Solution {
    public int solution(String word) {
        int answer = 0;
        
        for(int i=0;i<word.length();i++){
            String s = word.substring(i,i+1);
            switch(s){
                case "A":
                    answer++;
                    break;
                case "E":
                    for(int j=i;j<5;j++){
                        answer += Math.pow(5, 4-j);
                    }
                    answer++;
                    break;
                case "I":
                    for(int j=i;j<5;j++){
                        answer += 2 * Math.pow(5, 4-j);
                    }
                    answer++;
                    break;
                case "O":
                    for(int j=i;j<5;j++){
                        answer += 3 * Math.pow(5, 4-j);
                    }
                    answer++;
                    break;
                case "U":
                    for(int j=i;j<5;j++){
                        answer += 4 * Math.pow(5, 4-j);
                    }
                    answer ++;
                    break;
                default:
                    break;
            }
        }
        
        return answer;
    }
}