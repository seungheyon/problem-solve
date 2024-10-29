import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<double[]> arrList = new ArrayList<>();
        int idx = 0;
        for(int number : numbers){
            if(number<10){
                arrList.add(new double[]{number*100+number*10+number, idx});
            }
            else if (number<100){
                arrList.add(new double[]{number*10+((number/10 >= number%10) ? (number/10 - 0.1) : (number/10 + 0.1)), idx});
            }
            else if(number<1000){
                arrList.add(new double[]{number, idx});   
            }
            else{ // number == 1000
                arrList.add(new double[]{1, idx});   
            }
            idx ++;
        }
        Collections.sort(arrList, (a, b) -> Double.compare(b[0], a[0]));
        int iter = 0;
        for(double[] arr : arrList){
            if(iter==0 && arr[0]==0.0){
                return "0";
            }
            // System.out.print(arr[0]);
            // System.out.print("  ");
            // System.out.println(arr[1]);
            answer += numbers[(int)arr[1]];
            iter++;
        }
        
        
        return answer;
    }
}