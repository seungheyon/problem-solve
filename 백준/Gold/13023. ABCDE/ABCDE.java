import java.io.*;
import java.util.*;

public class Main {

    static boolean found = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] num = new int[m][2];

        Map<Integer, List<Integer>> intMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intMap.put(i, new LinkedList<>());
        }

        for(int i=0;i<m;i++){
            String[] str2 = br.readLine().split(" ");
            num[i][0] = Integer.parseInt(str2[0]);
            num[i][1] = Integer.parseInt(str2[1]);
            intMap.get(num[i][0]).add(num[i][1]);
            intMap.get(num[i][1]).add(num[i][0]);
        }
        boolean[] v = new boolean[n];

        for(int i : intMap.keySet()){
            findFriend(i, intMap, v, 0);
        }

        if(found){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }

    private static void findFriend(int n, Map<Integer, List<Integer>> intMap, boolean[] v, int fstack){
        if(found){
            return;
        }
        if(fstack>=4){
            found = true;
            return;
        }
        v[n] = true;
        for(Integer i : intMap.get(n)){
            if(!v[i]){
                findFriend(i, intMap, v, fstack+1);
                if(found){
                    return;
                }
            }
        }
        v[n] = false;
    }

}
