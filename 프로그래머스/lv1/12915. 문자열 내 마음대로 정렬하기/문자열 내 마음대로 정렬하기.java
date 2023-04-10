import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        //Map<String, Character> strmap = new HashMap<>();
        Set<Integer> iset = new HashSet<>();
        char[] carr = new char[strings.length];
        for(int i=0;i<strings.length;i++){
            carr[i] = strings[i].charAt(n);
        }
        Arrays.sort(carr);
        Arrays.sort(strings);

        loop1 : for(int i=0;i<carr.length;i++){
            for(int j=0;j<strings.length;j++){
                if(iset.contains(j)){
                    //System.out.println(strings[j]);
                    continue;
                }
                if(carr[i]==strings[j].charAt(n)){
                    answer[i] = strings[j];
                    iset.add(j);
                    continue loop1;
                }
            }
        }

        return answer;
    }
}