import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        //StringBuffer sb = new StringBuffer(s);
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()>0&&stack.peek()==s.charAt(i)){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        
        if(stack.isEmpty()){
            return 1;
        }
        return 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");
        // return answer;
    }
}