import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        // Use StringBuilder as a stack to store the result digits
        StringBuilder stack = new StringBuilder();
        
        // Track the number of digits to remove
        int toRemove = k;
        
        for (char digit : number.toCharArray()) {
            // While we can remove digits, and the current digit is larger than the top of the stack
            while (toRemove > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) < digit) {
                stack.deleteCharAt(stack.length() - 1); // Pop the smaller top digit
                toRemove--;  // One less digit to remove
            }
            // Push the current digit onto the stack
            stack.append(digit);
        }
        
        // If there are still digits left to remove, remove from the end of the stack
        stack.setLength(stack.length() - toRemove);

        // Convert the stack to a string and return
        return stack.toString();
    }
}