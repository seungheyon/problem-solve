import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input size of the array
        int n = Integer.parseInt(br.readLine());

        // Read array elements and store their values with indices
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i; // Original index
        }

        // Sort the array by value while keeping track of original indices
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        // Calculate the maximum displacement
        int maxRounds = 0;
        for (int i = 0; i < n; i++) {
            int originalIndex = arr[i][1];
            maxRounds = Math.max(maxRounds, originalIndex - i);
        }

        // Output the result: maximum displacement + 1
        System.out.println(maxRounds + 1);
    }
}