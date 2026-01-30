import java.util.*;

class Solution {
    
    static class Node{
        private String word;
        private int cnt;
        
        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    private int bfs(String begin, String target, String[] words){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        //이미 사용한 단어는 다시 안 씀
        boolean[] visited = new boolean[words.length];
        dp.add(new Node(begin, 0));
        
        while(!dp.isEmpty()){
            Node cur = dp.poll(); //맨 앞의 단어를 꺼냄
            
            if(cur.word.equals(target)) return cur.cnt;
            
            for(int i=0; i<words.length; i++){
                //아직 미방분 + 한글자만 다른 경우
                if(!visited[i] && check(cur.word, words[i])){
                    visited[i] = true;
                    dp.add(new Node(words[i], cur.cnt+1));
                }
            }
        }
        return 0;
    }
    
    private boolean check(String word, String target){
        int diff = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        
        return answer;
    }
}