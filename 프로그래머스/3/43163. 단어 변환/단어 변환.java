import java.util.*;
class Solution {
    
    static class Node {
        String s;
        int cnt;
        
        public Node(String s, int cnt){
            this.s = s;
            this.cnt = cnt;
        }
    }
    
    private int dfs(String begin, String target, String[] words){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
   
        while(!dp.isEmpty()){
            Node cur = dp.poll();
            
            if(cur.s.equals(target)) return cur.cnt;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.s, words[i])){
                    visited[i] = true;
                    dp.add(new Node(words[i], cur.cnt + 1));
                }
            }
        }
        return 0;
        
    }
    
    private boolean check(String s, String word){
        int dif = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != word.charAt(i)){
                dif++;
            }
        }
        return dif == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = dfs(begin, target, words);
        return answer;
    }
    
}