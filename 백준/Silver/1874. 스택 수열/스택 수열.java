import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int n = Integer.parseInt(sc.nextLine());
        int n = sc.nextInt();
        //int m = sc.nextInt();
        //sc.nextLine();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();

        List<Character> charList = new ArrayList<>();
        int cur = 1;
        for(int i=0;i<n;i++){
            while(true){
                if(!stack.isEmpty()){
                    if(stack.peek().equals(num[i])){
                        break;
                    }
                }
                stack.push(cur++);
                charList.add('+');
                if(cur>n+1){
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            charList.add('-');

        }

        for(Character symbol : charList){
            System.out.println(symbol);
        }

        //System.out.println();
    }
}
