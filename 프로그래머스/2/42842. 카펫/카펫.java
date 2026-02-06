import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int target = brown + yellow;
        for(int w = (int) Math.sqrt(target); w<=target; w++){
            if(target % w != 0) continue;
            int h = target/w;
            if((w-2) * (h-2) == yellow){
                if(w < h){
                    int tmp = w;
                    w = h;
                    h = tmp;
                }
                return new int[]{w, h};
            }
        }
        return new int[0];
    }
}