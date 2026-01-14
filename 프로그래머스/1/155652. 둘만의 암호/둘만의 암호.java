import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        Set<Character> skipSet = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) {
            skipSet.add(skip.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            int moved = 0;   
            int realMove = 0;   
            while (moved < index) {
                realMove++;

                char next = (char) ((cur - 'a' + realMove) % 26 + 'a');

                if (!skipSet.contains(next)) {
                    moved++;
                }
            }

            char result = (char) ((cur - 'a' + realMove) % 26 + 'a');
            sb.append(result);
        }

        return sb.toString();
    }
}