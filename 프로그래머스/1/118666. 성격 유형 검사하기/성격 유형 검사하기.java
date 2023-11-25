import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> mbtiMap = new HashMap<>();
        mbtiMap.put("R", 0);
        mbtiMap.put("T", 0);
        mbtiMap.put("C", 0);
        mbtiMap.put("F", 0);
        mbtiMap.put("J", 0);
        mbtiMap.put("M", 0);
        mbtiMap.put("A", 0);
        mbtiMap.put("N", 0);

        String answer = "";

        for(int i = 0;i<survey.length;i++){
            switch (choices[i]){
                case 1:
                    mbtiMap.put(String.valueOf(survey[i].charAt(0)), mbtiMap.get(String.valueOf(survey[i].charAt(0))) + 3);
                    break;
                case 2:
                    mbtiMap.put(String.valueOf(survey[i].charAt(0)), mbtiMap.get(String.valueOf(survey[i].charAt(0))) + 2);
                    break;
                case 3:
                    mbtiMap.put(String.valueOf(survey[i].charAt(0)), mbtiMap.get(String.valueOf(survey[i].charAt(0))) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    mbtiMap.put(String.valueOf(survey[i].charAt(1)), mbtiMap.get(String.valueOf(survey[i].charAt(1))) + 1);
                    break;
                case 6:
                    mbtiMap.put(String.valueOf(survey[i].charAt(1)), mbtiMap.get(String.valueOf(survey[i].charAt(1))) + 2);
                    break;
                case 7:
                    mbtiMap.put(String.valueOf(survey[i].charAt(1)), mbtiMap.get(String.valueOf(survey[i].charAt(1))) + 3);
                    break;
            }
        }
        
        if(mbtiMap.get("R")>=mbtiMap.get("T")){
            answer += "R";
        }
        else{
            answer += "T";
        }

        if(mbtiMap.get("C")>=mbtiMap.get("F")){
            answer += "C";
        }
        else{
            answer += "F";
        }

        if(mbtiMap.get("J")>=mbtiMap.get("M")){
            answer += "J";
        }
        else{
            answer += "M";
        }

        if(mbtiMap.get("A")>=mbtiMap.get("N")){
            answer += "A";
        }
        else{
            answer += "N";
        }

        return answer;
    }
}