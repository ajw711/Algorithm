import java.util.*;
class Solution {
    
    boolean[] visited;
    ArrayList<String> all = new ArrayList<>();
    
    public void dfs(String cur, String path, String[][] tickets, int count){
        if(count == tickets.length){
            all.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                dfs(tickets[i][1], path+" "+tickets[i][1], tickets, count+1);
                
                if(all.size() > 0) return;
                // 백트래킹: 티켓 사용 취소
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        //사전 순 정렬
        Arrays.sort(tickets, (a, b) ->{
            if(!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
    
        
        return all.get(0).split(" ");
    }
}