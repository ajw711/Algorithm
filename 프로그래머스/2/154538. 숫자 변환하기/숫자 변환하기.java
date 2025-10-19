import java.util.*;

class Solution {
 
    static int bfs(int x, int y, int n){
         if (x == y) return 0;
        
        ArrayDeque<int []> dp = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        dp.add(new int []{x, 0});
        visited[x] = true;
  
        while(!dp.isEmpty()){
            int[] p = dp.poll();
            int cx = p[0];
            int cnt = p[1];
            
            int[] nums = {cx+n , cx*2 , cx*3};
            
            for(int next : nums){
                if(next > y || visited[next]) continue;
                
                if(next == y){
                    return cnt + 1;
                }
                
                visited[next] = true;
                dp.add(new int[]{next, cnt+1});
            }
            
        }
        return -1;
    }
    
    public int solution(int x, int y, int n) {
        int answer = 0;

        return bfs(x, y, n);
    }
}