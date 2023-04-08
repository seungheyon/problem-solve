class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1){
            int[] answer = {-1};
            return answer;
        }        
        int[] answer = new int[arr.length-1];
        int min = arr[0];
        for(int a:arr){
            if(min>a){
                min = a;
            }
        }
        System.out.println(min);
        int i = 0;
        for(int a:arr){
            if(a==min){
                continue;
            }
            answer[i] = a;
            i++;
        }
        return answer;
    }
}