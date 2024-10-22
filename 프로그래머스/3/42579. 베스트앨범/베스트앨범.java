import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, List<Integer>> genrePlayedMap = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            if(genrePlayedMap.containsKey(genres[i])){
                int playCount = genrePlayedMap.get(genres[i]).get(0) + plays[i];
                int p1 = genrePlayedMap.get(genres[i]).get(1);
                int p2 = genrePlayedMap.get(genres[i]).get(2);
                if(plays[i]>plays[p1]){
                    p2 = p1;
                    p1 = i;
                }
                else if(p2<0){
                    p2 = i;
                }
                else if(plays[i]>plays[p2]){
                    p2 = i;
                }
                genrePlayedMap.put(genres[i], Arrays.asList(playCount, p1, p2));
                continue;
            }
            genrePlayedMap.put(genres[i], Arrays.asList(plays[i], i, -1));
        }
        
        
        List<Map.Entry<String, List<Integer>>> entryList = new ArrayList<>(genrePlayedMap.entrySet());
        entryList.sort(Comparator.comparing(entry -> entry.getValue().get(0), Comparator.reverseOrder()));
        
        List<Integer> result = new ArrayList<>();
        
        for(Map.Entry<String, List<Integer>> entry : entryList){
            result.add(genrePlayedMap.get(entry.getKey()).get(1));
            if(genrePlayedMap.get(entry.getKey()).get(2)>=0){
                result.add(genrePlayedMap.get(entry.getKey()).get(2));
            }
        }
        
        answer = result.stream().mapToInt(Integer::intValue)
                                .toArray();
        
        
        return answer;
    }
}