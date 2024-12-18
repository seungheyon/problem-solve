import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // 배열 정렬
        Arrays.sort(numbers);

        int answer = 0;

        // 좋은 수 찾기
        for (int i = 0; i < n; i++) {
            int target = numbers[i];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                // 자기 자신은 포함하지 않음
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = numbers[left] + numbers[right];

                if (sum == target) {
                    answer++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}