import java.util.*;

class Solution {
    
    static int formmaterSum (String s, int addMonth){
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(5, 7));
        int day = Integer.parseInt(s.substring(8, 10));

    
        int total = year * 12 * 28 + month * 28 + day;

        if (addMonth != -1) {
            total += addMonth * 28;
        }

        return total;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList();
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : terms){
            String[] s1 = s.split(" ");
            map.put(s1[0], Integer.parseInt(s1[1]));
        }
        //2021.05.02
        //0123456789
        int index = 1;
        for(String s : privacies){
            String[] s1 = s.split(" ");
            int target_term = map.get(s1[1]);
            int target_sum = formmaterSum(s1[0], target_term);
            int today_sum = formmaterSum(today, -1);
            if(today_sum > target_sum-1) {
                answer.add(index);
            }
            index++;
        }
        
        return answer.stream().mapToInt( i -> i).toArray();
    }
}