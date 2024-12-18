import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); // Length of the DNA string
        int p = sc.nextInt(); // Length of the substring to use as a password
        sc.nextLine();
        String str = sc.nextLine(); // DNA string
        int[] arr = new int[4]; // Minimum required counts of 'A', 'C', 'G', 'T'
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Frequency map for current window
        Map<Character, Integer> pMap = new HashMap<>();
        pMap.put('A', 0);
        pMap.put('C', 0);
        pMap.put('G', 0);
        pMap.put('T', 0);

        char[] dna = str.toCharArray();
        int answer = 0;

        // Initialize the first window
        for (int i = 0; i < p; i++) {
            pMap.put(dna[i], pMap.get(dna[i]) + 1);
        }

        // Check the first window
        if (pMap.get('A') >= arr[0] &&
            pMap.get('C') >= arr[1] &&
            pMap.get('G') >= arr[2] &&
            pMap.get('T') >= arr[3]) {
            answer++;
        }

        // Slide the window
        for (int i = p; i < s; i++) {
            // Add the new character to the window
            pMap.put(dna[i], pMap.get(dna[i]) + 1);

            // Remove the old character from the window
            char toRemove = dna[i - p];
            pMap.put(toRemove, pMap.get(toRemove) - 1);

            // Check if the current window satisfies the conditions
            if (pMap.get('A') >= arr[0] &&
                pMap.get('C') >= arr[1] &&
                pMap.get('G') >= arr[2] &&
                pMap.get('T') >= arr[3]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}