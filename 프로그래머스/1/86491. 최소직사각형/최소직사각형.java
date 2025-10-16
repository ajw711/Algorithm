import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;
        for(int i=0; i<sizes.length; i++){
            int max_v = Math.max(sizes[i][0], sizes[i][1]);
            int min_v = Math.min(sizes[i][0], sizes[i][1]);
            
            max = Math.max(max, max_v);
            min = Math.max(min, min_v);
        }

        return max*min;
    }
}