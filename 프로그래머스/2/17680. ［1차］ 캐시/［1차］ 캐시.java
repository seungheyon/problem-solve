import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>(cacheSize);
        int executeTime = 0;
        
        if(cacheSize==0){
            return 5*cities.length;
        }
        for (String city : cities) {
            city = city.toUpperCase();
            if (cache.contains(city)) {
                executeTime += 1;
                if(cache.size()==cacheSize){
                    cache.remove(city);
                }

                cache.add(city);
            } else {
                executeTime += 5;
                if (cacheSize > 0 && cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
            }
        }

        return executeTime;
    }
}