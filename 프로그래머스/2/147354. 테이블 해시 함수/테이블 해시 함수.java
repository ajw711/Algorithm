import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[] s = new int[data.length];
        
        Arrays.sort(data, (a, b) -> {
          if(a[col-1] == b[col-1]){
              return Integer.compare(b[0], a[0]);
          }
            return Integer.compare(a[col-1], b[col-1]);
        }); 
        
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data[i].length; j++){
                 s[i] += data[i][j] % (i + 1);
            }
        }
        for(int i=row_begin; i<=row_end; i++){
             answer ^= s[i - 1];
        }
        
        return answer;
    }
}