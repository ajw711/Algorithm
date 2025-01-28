  // import static org.junit.jupiter.api.Assertions.assertEquals;
  
  // import org.junit.jupiter.api.Test;
  import java.util.*;
  import java.io.*;

  class Node{
    int x;
    int y;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }

    public int getX(){
      return x;
    }
    public int getY(){
      return y;
    }
    
  }
  
  public class Main {
  
    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static int W, H;
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    static int [][] arr;
    static boolean [][] visited;

    static void bfs(int start_x, int start_y, int[][] map, boolean[][] visited){

      ArrayDeque<Node> q = new ArrayDeque<>();
      q.add(new Node(start_x, start_y));
      visited[start_x][start_y] = true;

      while(!q.isEmpty()){

        Node node = q.poll();
        int cx = node.getX();
        int cy = node.getY();

        for(int i=0; i<8; i++){
          int nx = cx + dx[i];
          int ny = cy + dy[i];
          if(0<= nx && nx < H && 0<= ny && ny < W){
            if(visited[nx][ny] == false && map[nx][ny] == 1){
              q.add(new Node(nx, ny));
              visited[nx][ny] = true;
            }
            
          }
        }
        
      }
    }



    
    
    public static void main(String[] args) throws IOException {

      while (true){
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        if ( W == 0 && H == 0){
          break;
        }
        
         arr = new int [H][W];
         visited = new boolean [H][W];
        
        for(int i=0; i<H; i++){
          st = new StringTokenizer(br.readLine());
          for (int j=0; j<W; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
            visited[i][j] = false;
          }
        }

        
        int cnt = 0;
        
        for(int x=0; x<H; x++){
          for(int y=0; y<W; y++){
            if(!visited[x][y] && arr[x][y] == 1){
              bfs(x,y,arr,visited);
              cnt+=1;
            }
          }
        }
        
        System.out.println(cnt);
        

        
        
      }
      

      
    }
  
  
  }