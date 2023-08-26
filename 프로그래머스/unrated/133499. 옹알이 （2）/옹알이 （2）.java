import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] babbleWords = {"aya", "ye", "woo", "ma"};

        for(String word : babbling){
            String beforebabble = "";
            while (true){
                boolean match = false;
                for(String babble : babbleWords){
                    if(word.startsWith(babble)){
                        if(babble.equals(beforebabble)){
                            break;
                        }
                        beforebabble = babble;
                        match = true;
                        word = word.substring(babble.length());
                        if(word.equals("")){
                            break;
                        }
                    }
                }
                if(word.equals("")){
                    answer +=1;
                    break;
                }
                if(!match){
                    break;
                }
            }
        }

        return answer;
    }
}