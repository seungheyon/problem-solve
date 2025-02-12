import java.io.*;
import java.util.*;

public class Main {

    static int[] parentOf;
    static  boolean[] visited;
    static int leafCount = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());

        //List<Edge> edges = new ArrayList<>();
        parentOf = new int[n];
        visited = new boolean[n+1];

        Map<Integer, List<Integer>> intMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            intMap.put(i, new ArrayList<>());
        }

        String[] str = br.readLine().split(" ");
        int root = -1;
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(str[i]);
            if(a==-1){
                intMap.get(i).add(-1);
                root = i;
                continue;
            }

            parentOf[i] = a;
            if(!intMap.containsKey(i)){
                List<Integer> list = new ArrayList<>();
                intMap.put(i, list);
            }
            intMap.get(i).add(a);

            if(!intMap.containsKey(a)){
                List<Integer> list = new ArrayList<>();
                intMap.put(a, list);
            }
            intMap.get(a).add(i);
        }

        int erase = Integer.parseInt(br.readLine());
        if(erase==root){
            System.out.println(0);
            return;
        }

        visited[root] = true;

        eraseNode(root, intMap, -1, erase);

        System.out.println(leafCount);


    }

    private static void eraseNode(int node, Map<Integer, List<Integer>> intMap, int parent, int erase){

        visited[node] = true;
        if(intMap.get(node).size()==1){
            leafCount++;
            return;
        }
        for(int child : intMap.get(node)){
            if(child!=parent&&!visited[child]){
                if(child==erase){
                    if(intMap.get(node).size()==2){
                        leafCount++;
                    }
                    continue;
                }
                eraseNode(child, intMap, node, erase);
            }
        }
    }
}