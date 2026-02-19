import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> dp = new ArrayDeque<String>();
        Set<String> set = new HashSet<>();
        
        // 어차피 다 miss로 구성됨
        if(cacheSize == 0) return cities.length * 5;
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            
            // 포함
            if(set.contains(city)){
                dp.remove(city);
                dp.push(city);
                answer+=1;
            }else { // 포함하지 않음
                if(dp.size() == cacheSize){
                    String removed = dp.removeLast();
                    set.remove(removed);
                }
                dp.push(city);
                set.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}