import java.util.*;
class Solution {
    
    static boolean check(String[][] park, int x, int y, int num){
        // 범위 체크
        if(x+num > park.length || y+num > park[0].length) return false;
        
        for(int i=x; i<x+num; i++){
            for(int j=y; j<y+num; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        
        return true;
    }
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    for(int k=mats.length-1; k>=0; k--){
                        if(check(park, i, j, mats[k])){
                            answer = Math.max(answer, mats[k]);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}