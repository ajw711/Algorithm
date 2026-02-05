import java.util.*;
class Solution {
    Set<Integer>  set = new HashSet<>();
    boolean[] visited;
    
    private void dfs(String numbers, String cur){
        if(!cur.isEmpty()){
            set.add(Integer.parseInt(cur));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, cur+numbers.charAt(i));
                visited[i] = false;
            }
        }

    }
    
    private boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        dfs(numbers, "");
        for(int num: set){
            if(isPrime(num)) answer++;
        }
        return answer;
    }
}