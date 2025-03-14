import java.util.*;
import java.io.*;

class Node{
  private int x;
  private int y;
  private int cnt;

  public Node(int x, int y, int cnt){
    this.x = x;
    this.y = y;
    this.cnt = cnt;
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public int getCnt(){
    return this.cnt;
  }
  
}

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int [][] arr;
  static int [][][] visited;
  static int [] dx = {-1, 1, 0, 0};
  static int [] dy = {0, 0, -1, 1};

  static int bfs(int start_x, int start_y){
    ArrayDeque<Node> dp = new ArrayDeque<Node>();
    dp.add(new Node(start_x, start_y, 0));
    visited[start_x][start_y][0] = 1;

    while(!dp.isEmpty()){
      
      Node p = dp.poll();
      int cx = p.getX();
      int cy = p.getY();
      int cnt = p.getCnt();
      if( cx == N-1 && cy == M-1 ){
        return visited[cx][cy][cnt];
      }
      
      for(int i = 0; i < 4; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if(0<= nx && nx < N && 0 <= ny && ny < M){
          if(arr[nx][ny] == 1 && visited[nx][ny][1] == 0 && cnt == 0){
            dp.add(new Node(nx, ny, cnt + 1));
            visited[nx][ny][1] = visited[cx][cy][0] + 1;
          }else if(arr[nx][ny] == 0 && visited[nx][ny][cnt] == 0){
            dp.add(new Node(nx, ny, cnt));
            visited[nx][ny][cnt] = visited[cx][cy][cnt] + 1;
          }
        }
      }
    }

    return -1;
    
  }

  
  
  public static void main(String[] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    visited = new int[N][M][2];

    for(int i = 0; i < N; i++){
      String s = br.readLine();
      for(int j = 0; j < M; j++){
        arr[i][j] = s.charAt(j) - '0';
      }
    }
    System.out.println(bfs(0,0));
    
  }
}