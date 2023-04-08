class Solution {
    public int[] solution(long n) {
        int len = (int)Math.log10(n) + 1;
        int[] answer = new int[len];
        String str = String.valueOf(n);
        int i = 1;
        while(i<=len){
            answer[i-1] = Integer.parseInt(str.substring(len-i,len-i+1));
            //System.out.println(answer[i-1]);
            i++;
        }
        return answer;
    }
}