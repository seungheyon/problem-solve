import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> rstack = new Stack<Character>();
        int a = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals("(")){
                //rstack.push(s.substring(i,i+1).charAt(0));
                a++;
                //System.out.print(a);
                //System.out.println("   add");
            }
            else{
                //rstack.pop();
                a--;
                if(a<0){
                    return false;
                }
                //System.out.println(a);
            }
        }

        //System.out.println();
        //System.out.println(a);
        return a==0;
    }
}