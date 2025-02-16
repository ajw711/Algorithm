
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int N,M;

    static char [][] arr;
    static boolean[][] visited_b;
    static boolean[][] visited_w;

    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};


    static int bfs_b(int start_x , int start_y){

        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start_x, start_y));
        visited_b[start_x][start_y] = true;
        int cnt = 1;

        while(!dp.isEmpty()){
            Node p = dp.poll();
            int cx = p.getX();
            int cy = p.getY();
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0<=nx && nx<M && 0<=ny && ny<N && !visited_b[nx][ny] && arr[nx][ny] == 'B'){
                   dp.add(new Node(nx, ny));
                   visited_b[nx][ny] = true;
                   cnt+=1;
                }
            }
        }
        return cnt*cnt;
    }

    static int bfs_w(int start_x , int start_y){

        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start_x, start_y));
        visited_w[start_x][start_y] = true;
        int cnt = 1;

        while(!dp.isEmpty()){
            Node p = dp.poll();
            int cx = p.getX();
            int cy = p.getY();
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0<=nx && nx<M && 0<=ny && ny<N && !visited_w[nx][ny] && arr[nx][ny] == 'W'){
                    dp.add(new Node(nx, ny));
                    visited_w[nx][ny] = true;
                    cnt+=1;
                }
            }
        }
        return cnt*cnt;
    }



    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        visited_b = new boolean[M][N];
        visited_w = new boolean[M][N];

        for(int i=0; i<M; i++){
            char[] s = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                arr[i][j] = s[j];
            }
        }
        int answer_w = 0;
        int answer_b = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited_b[i][j] && arr[i][j] == 'B'){
                    answer_b += bfs_b(i, j);
                }else if(!visited_w[i][j] && arr[i][j] == 'W'){
                    answer_w += bfs_w(i, j);
                }
            }
        }
        System.out.println(answer_w+" "+answer_b);
    }

}