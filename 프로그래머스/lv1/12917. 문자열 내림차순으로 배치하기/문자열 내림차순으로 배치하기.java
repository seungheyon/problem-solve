import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            arr.add((int)a);
        }
        arr.sort(Comparator.reverseOrder());
        for(int i=0;i<arr.size();i++){
            sb.append(Character.toChars(arr.get(i)));
        }
        answer = sb.toString();
        System.out.println();

        return answer;
    }
}