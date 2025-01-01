import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
//        Scanner sc = new Scanner(System.in);

        
        int[][] num = new int[m][2];
        Map<Integer, List<Integer>> intMap = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            intMap.put(i, new LinkedList<>());
        }
        
        for(int i=0;i<m;i++){
            String[] stri = br.readLine().split(" ");
            num[i][0] = Integer.parseInt(stri[0]);
            num[i][1] = Integer.parseInt(stri[1]);
            if(intMap.containsKey(num[i][0])){
                intMap.get(num[i][0]).add(num[i][1]);
            }
            else{
                List<Integer> newList = new LinkedList<>();
                newList.add(num[i][1]);
                intMap.put(num[i][0], newList);
            }
            if(intMap.containsKey(num[i][1])){
                intMap.get(num[i][1]).add(num[i][0]);
            }
            else{
                List<Integer> newList = new LinkedList<>();
                newList.add(num[i][0]);
                intMap.put(num[i][1], newList);
            }
        }

        //System.out.println("out--");


        boolean[] visited = new boolean[n+1];
        int answer = 0;
        for(Integer i : intMap.keySet()){
            if(!visited[i]){
                answer++;
                dfs(i, intMap, visited);
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int n, Map<Integer, List<Integer>> intMap, boolean[] visited){
        visited[n] = true;
        for(Integer i : intMap.get(n)){
            if(!visited[i]){
                dfs(i, intMap, visited);
            }
        }
    }
}