import java.util.*;
import java.io.*;


public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] arr;
  static int [] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
  static int [] dy = {0, 0, -1, 1, -1, -1, 1, 1};
  static boolean [][] visited;

  static void dfs(int start_x, int start_y){
     visited[start_x][start_y] = true;
    for(int i =0; i<8; i++){
      int nx = start_x + dx[i];
      int ny = start_y + dy[i];
      if( 0<= nx && nx<N && 0<= ny && ny<M){
        if(arr[nx][ny] == 1 && !visited[nx][ny]){
          dfs(nx, ny);
        }
      }
    }
  }
  
  
  public static void main(String[] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    visited = new boolean[N][M];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    int cnt = 0;

    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
          if (arr[i][j] == 1 && !visited[i][j]){
            dfs(i, j);
            cnt+=1;
          }
      }
    }
    System.out.println(cnt);
    
  }
}