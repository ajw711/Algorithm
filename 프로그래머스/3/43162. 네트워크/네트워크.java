import java.util.*;

class Solution {
    
    static void dfs(int depth, int[][] computers, boolean[] visited){
        visited[depth] = true;
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i] && computers[depth][i] == 1){
                dfs(i, computers, visited);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
}