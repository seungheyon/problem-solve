import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        Set<String> routeSet = new HashSet<>();
        int[][] doubleRectangles = makeRectangleDouble(rectangle);
        for(int[] ract : doubleRectangles){
            insertHorizontalRoute(0, 2, 1, ract, routeSet, doubleRectangles);
            insertHorizontalRoute(0, 2, 3, ract, routeSet, doubleRectangles);
            insertVerticalRoute(1, 3, 0, ract, routeSet, doubleRectangles);
            insertVerticalRoute(1, 3, 2, ract, routeSet, doubleRectangles);
        }
        
        System.out.println(routeSet.size());
        System.out.println(routeSet);
        
        // bfs
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{characterX*2, characterY*2});
        int[] goal = new int[]{itemX*2, itemY*2};
        
        while(!que.isEmpty()){
            int s = que.size();
            for(int i=0;i<s;i++){
                int[] cur = que.poll();
                if(cur[0]==goal[0]&&cur[1]==goal[1]){
                    return answer/2;
                }
                // 인접한 route 를 Set 에서 추출 후 Queue 에 삽입, Set 에서 제거
                closeRouteInsertQueue(cur, routeSet, que);
            }
            answer++;
        }
        
        
        return answer;
    }
    
    private void insertHorizontalRoute(int from, int to, int piv, int[] ract, Set<String> routeSet, int[][] doubleRectangles){
        for(int i=ract[from];i<=ract[to];i++){
            // 내부에 있지 않다면
            int[] route = new int[]{i, ract[piv]};
            if(!isInside(route, doubleRectangles)){
                routeSet.add(route[0]+","+route[1]);
            }
        }
    }
    
    private void insertVerticalRoute(int from, int to, int piv, int[] ract, Set<String> routeSet, int[][] doubleRectangles){
        for(int i=ract[from];i<=ract[to];i++){
            int[] route = new int[]{ract[piv], i};
            if(!isInside(route, doubleRectangles)){
                routeSet.add(route[0]+","+route[1]);
            }
        }
    }
    
    private boolean isInside(int[] route, int[][] doubleRectangle){
        // ract[0] ~ ract[2] , ract[1] ~ ract[3]
        for(int[] ract : doubleRectangle){
            if(route[0]>ract[0]&&route[0]<ract[2]&&route[1]>ract[1]&&route[1]<ract[3]){
                return true;
            }
        }
        return false;
    }
    
    private int[][] makeRectangleDouble(int[][] rectangle){
        int[][] doubleRectangles = new int[rectangle.length][rectangle[0].length];
        for(int i=0;i<rectangle.length;i++){
            for(int j=0;j<rectangle[0].length;j++){
                doubleRectangles[i][j] = 2*rectangle[i][j];
            }
        }
        return doubleRectangles;
    }
    
    private void closeRouteInsertQueue(int[] cur, Set<String> routeSet, Queue<int[]> que){
        int xplus = cur[0]+1;
        int xminus = cur[0]-1;
        int yplus = cur[1]+1;
        int yminus = cur[1]-1;
        if(!routeSet.isEmpty()){
            if(routeSet.contains(xplus+","+cur[1])){
                que.add(new int[]{xplus,cur[1]});
                routeSet.remove(xplus+","+cur[1]);
            }
        }
        if(!routeSet.isEmpty()){
            if(routeSet.contains(xminus+","+cur[1])){
                que.add(new int[]{xminus,cur[1]});
                routeSet.remove(xminus+","+cur[1]);
            }
        }
        if(!routeSet.isEmpty()){
            if(routeSet.contains(cur[0]+","+yplus)){
                que.add(new int[]{cur[0],yplus});
                routeSet.remove(cur[0]+","+yplus);
            }
        }
        if(!routeSet.isEmpty()){
            if(routeSet.contains(cur[0]+","+yminus)){
                que.add(new int[]{cur[0],yminus});
                routeSet.remove(cur[0]+","+yminus);
            }
        }
    }
}