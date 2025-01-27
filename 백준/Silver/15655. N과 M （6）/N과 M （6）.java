  // import static org.junit.jupiter.api.Assertions.assertEquals;
  
  // import org.junit.jupiter.api.Test;
  import java.util.*;
  import java.io.*;
  
  public class Main {
  
    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] visited;
    static int[] arr;
  
  
    static void dfs(int depth, int start, Deque<Integer> q){
  
  
        if( depth == M){
          for(Integer num : q){
            System.out.print(num+" ");
          }
          System.out.println();
          return ;
        }
      
  
       
        for(int i=start; i<N; i++){
          if(visited[i]){
            continue;
          }
          visited[i] = true;
          q.add(arr[i]);
          dfs(depth+1, i+1, q);
          visited[i] = false;
          q.pollLast();
          
        }
      
    }
    
    
    public static void main(String[] args) throws IOException {
  
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
  
      arr = new int[N];
      visited = new boolean[N];
  
      st = new StringTokenizer(br.readLine());
      
      for(int i=0; i<N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        visited[i] = false;
      }
  
      Arrays.sort(arr);
  
      dfs(0,0, new ArrayDeque<Integer>());
      
    }
  
  
  }