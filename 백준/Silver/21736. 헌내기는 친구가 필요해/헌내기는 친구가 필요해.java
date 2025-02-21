import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static char [][] arr;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1 ,1};
    static boolean [][] visited;

    static int bfs(int start_x, int start_y) {

        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start_x, start_y));
        visited[start_x][start_y] = true;
        int cnt = 0;

        while(!dp.isEmpty()){
            Node p = dp.poll();
            int cx = p.getX();
            int cy = p.getY();
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && arr[nx][ny] != 'X'){
                    if(arr[nx][ny] == 'P'){
                        cnt+=1;
                    }
                    dp.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr  = new char[N][M];
        visited  = new boolean[N][M];
        int start_x = 0;
        int start_y = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'I'){
                   start_x = i;
                   start_y = j;
                }
            }
        }
        int result = bfs(start_x, start_y);
        if(result == 0){
            System.out.println("TT");
        }else{
            System.out.println(result);
        }
    }




}