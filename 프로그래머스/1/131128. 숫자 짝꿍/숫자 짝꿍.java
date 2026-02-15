import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        //String answer = "-1";
        Map<Character, Integer> Xmap = new HashMap<>();
        Map<Character, Integer> Ymap = new HashMap<>();
        for(int i=0;i<X.length();i++){
            char cur = X.charAt(i);
            if(Xmap.containsKey(cur)){
                Xmap.put(cur, Xmap.get(cur)+1);
                continue;
            }
            Xmap.put(cur, 1);
        }
        for(int i=0;i<Y.length();i++){
            char cur = Y.charAt(i);
            if(Ymap.containsKey(cur)){
                Ymap.put(cur, Ymap.get(cur)+1);
                continue;
            }
            Ymap.put(cur, 1);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=9;i>=0;i--){
            int min = 0;
            if(Xmap.containsKey((char)(i+'0'))&&Ymap.containsKey((char)(i+'0'))){
                min = (Xmap.get((char)(i+'0'))>Ymap.get((char)(i+'0'))) ? Ymap.get((char)(i+'0')) : Xmap.get((char)(i+'0'));
            }
            if(i==0&&sb.length()==0&&min>0){
                sb.append("0");
                break;
            }
            for(int j=0;j<min;j++){
                sb.append(i);
            }
        }
        //System.out.println("printchari : "+Xmap.get((char)(1+'0')));
        // System.out.println(Xmap);
        // System.out.println(Ymap);
        // System.out.println(sb.toString());
        // System.out.println(sb.toString());

        String answer = sb.toString();
        if(answer.equals("")){
            return "-1";
        }
        return answer;
    }
}