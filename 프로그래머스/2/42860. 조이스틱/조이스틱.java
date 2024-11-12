import java.util.*;
class Solution {
    int minTotalDistance = 400;
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        
        int minVertical = 0;
        
        String[] nameArray = name.split("");
        boolean[] isDone = new boolean[size];
        
        Map<String, Integer> alpMap = new HashMap<>();
        alpMap.put("A", 0);
        alpMap.put("B", 1);
        alpMap.put("C", 2);
        alpMap.put("D", 3);
        alpMap.put("E", 4);
        alpMap.put("F", 5);
        alpMap.put("G", 6);
        alpMap.put("H", 7);
        alpMap.put("I", 8);
        alpMap.put("J", 9);
        alpMap.put("K", 10);
        alpMap.put("L", 11);
        alpMap.put("M", 12);
        alpMap.put("N", 13);
        alpMap.put("O", 12);
        alpMap.put("P", 11);
        alpMap.put("Q", 10);
        alpMap.put("R", 9);
        alpMap.put("S", 8);
        alpMap.put("T", 7);
        alpMap.put("U", 6);
        alpMap.put("V", 5);
        alpMap.put("W", 4);
        alpMap.put("X", 3);
        alpMap.put("Y", 2);
        alpMap.put("Z", 1);
        
        for(int i=0;i<size;i++){
            if(nameArray[i].equals("A")){
                isDone[i] = true;
            }
            minVertical += alpMap.get(nameArray[i]);
        }
        
        findRoot(0, 0, size, isDone);
        
        System.out.println(minVertical);
        System.out.println(minTotalDistance);
        
        return minVertical + minTotalDistance;
        
        
//         int idx = 0;
//         boolean notDone = true;
//         while(notDone){
//             answer += alpMap.get(nameArray[idx]);
//             isDone[idx] = true;
//             // System.out.print("+");
//             // System.out.println(nameArray[idx]);
//             // System.out.println(answer);
//             // System.out.println("");
            
//             notDone = false;
//             for(boolean done : isDone){
//                 if(done==false){
//                     notDone = true;
//                 }
//             }
            
//             int r = 1;
//             while(r<size&&isDone[(idx + r)%size]){r++;}
//             int l = 1;
//             while(l<size&&isDone[(idx - l + size)%size]){l++;}
//             if(r>l){
//                 idx = (idx-l+size)%size;
//                 answer +=l;
//                 // System.out.print("+l : ");
//                 // System.out.print(l);
//                 // System.out.print("=");
//                 // System.out.println(answer);
//             }
//             else{
//                 idx = (idx+r)%size;
//                 answer +=r;
//                 // System.out.print("+r : ");
//                 // System.out.print(r);
//                 // System.out.print("=");
//                 // System.out.println(answer);
//             }
//             // System.out.println("-------------------");
//         }
        
//         return answer-size;
    }
    
    private void findRoot(int minRoot, int idx, int size, boolean[] isDone){
        isDone[idx] = true;
        boolean[] isdone = new boolean[size];
        // System.out.print(minRoot);
        // System.out.print("  [ ");
        for(int i=0;i<size;i++){
            // System.out.print(isDone[i]);
            // System.out.print(", ");
            isdone[i] = isDone[i];
        }
        //System.out.println("] ");
        for(int i=0;i<size;i++){
            if(isDone[i]==false){
                break;
            }
            if(i==size-1){
                //System.out.println(minRoot);
                minTotalDistance = Math.min(minTotalDistance, minRoot);
                return;
            }
        }
        int r = 1;
        while(r<size&&isDone[(idx + r)%size]){r++;}
        int l = 1;
        while(l<size&&isDone[(idx - l + size)%size]){l++;}
        findRoot(minRoot+l, (idx - l + size)%size, size, isDone);
        
        findRoot(minRoot+r, (idx + r)%size, size, isdone);
    }
}