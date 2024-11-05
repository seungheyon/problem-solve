import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int length = answers.length;
        int[] one = new int[length];
        int[] two = new int[length];
        int[] three = new int[length];
        
        int numOne;
        for(int i=0;i<length/5 + 1;i++){
            numOne = 1;
            for(int j = 0;j<5;j++){
                if(i*5 + j>=length){
                    break;
                }
                one[i*5 + j] = numOne++;
            }
            if(i==length/5){
                break;
            }
        }
        
        
        
        for(int i=0;i<length/8 + 1;i++){
            numOne = 1;
            for(int j = 0;j<8;j++){
                if(i*8 + j>=length){
                    break;
                }
                if(j%2==0){
                    two[i*8 + j] = 2;
                }
                else{
                    if(j==3){
                        numOne++;
                    }
                    two[i*8 + j] = numOne++;
                }           
            }
            if(i==length/8){
                break;
            }
        }
        
        
        
        for(int i=0;i<length/10 + 1;i++){
            for(int j = 0;j<10;j++){
                if(i*10 + j>=length){
                    break;
                }
                if(j==0||j==1){
                    three[i*10 + j] = 3;
                }
                if(j==2||j==3){
                    three[i*10 + j] = 1;
                }
                if(j==4||j==5){
                    three[i*10 + j] = 2;
                }
                if(j==6||j==7){
                    three[i*10 + j] = 4;
                }
                if(j==8||j==9){
                    three[i*10 + j] = 5;
                }
            }
            if(i==length/10){
                break;
            }
        }
        
        System.out.print("[ ");
        for(int i: one){
            System.out.print(i);
        }
        System.out.println(" ]");
        
        System.out.print("[ ");
        for(int i: two){
            System.out.print(i);
        }
        System.out.println(" ]");
        
        System.out.print("[ ");
        for(int i: three){
            System.out.print(i);
        }
        System.out.println(" ]");
        
        int oneAns = 0;
        int twoAns = 0;
        int threeAns = 0;
        
        int max = 0;
        
        for(int i = 0;i<length;i++){
            if(one[i]==answers[i]){
                oneAns++;
                if(max<oneAns){
                    max = oneAns;
                }
            }
            if(two[i]==answers[i]){
                twoAns++;
                if(max<twoAns){
                    max = twoAns;
                }
            }
            if(three[i]==answers[i]){
                threeAns++;
                if(max<threeAns){
                    max = threeAns;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        if(max == oneAns){
            ans.add(1);
        }
        if(max == twoAns){
            ans.add(2);
        }
        if(max == threeAns){
            ans.add(3);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}