import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int s1 = 0;
        int s2 = 2;
        int s2pair = 0;
        int s3 = 3;
        int icnt = 0;

        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;

        int max = 0;

        for(int i=0;i<answers.length;i++){

            s1 = s1%5 + 1;
            if(i%2!=0){
                s2pair = s2pair%5+1;
                if(s2pair==2){
                    s2pair +=1;
                }
            }
            s2 = (i%2==0)? 2 : s2pair;
            icnt = i%10;
            switch (icnt){
                case 0:
                case 1:
                    s3 = 3;
                    break;
                case 2:
                case 3:
                    s3 = 1;
                    break;
                case 4:
                case 5:
                    s3 = 2;
                    break;
                case 6:
                case 7:
                    s3 = 4;
                    break;
                case 8:
                case 9:
                    s3 = 5;
                    break;
                default:
                    break;
            }

            // 정답 비교
            if(answers[i]==s1){
                answer1++;
                if(max<answer1){
                    max = answer1;
                }
            }
            if(answers[i]==s2){
                answer2++;
                if(max<answer2){
                    max = answer2;
                }
            }
            if(answers[i]==s3){
                answer3++;
                if(max<answer3){
                    max = answer3;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        if(max==answer1){
            arr.add(1);
        }
        if(max==answer2){
            arr.add(2);
        }
        if(max==answer3){
            arr.add(3);
        }

        int[] answer = new int[arr.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}