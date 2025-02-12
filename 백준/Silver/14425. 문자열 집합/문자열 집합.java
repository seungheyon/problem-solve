import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);


        Set<String> strSet = new HashSet<>();
        String[] strings = new String[m];

        for(int i=0;i<n;i++){
            strSet.add(br.readLine());
        }
        for(int i=0;i<m;i++){
            strings[i] = br.readLine();
        }

        int matchCnt = 0;

        for(String string : strings){
            if(strSet.contains(string)){
                matchCnt++;
            }
        }

        System.out.println(matchCnt);

    }
}