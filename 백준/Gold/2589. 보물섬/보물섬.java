import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

class Node{
    private int x;
    private int y;

    private int dis;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Node(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDis() {
        return dis;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static ArrayDeque<Node> dp = new ArrayDeque<>();
    static char [][] arr;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int bfs(int start_x, int start_y){
        ArrayDeque<Node> p = new ArrayDeque<>();
        p.add(new Node(start_x, start_y, 0));

        boolean[][] visited = new boolean[N][M];
        visited[start_x][start_y] = true;

        int max = 0;

        while(!p.isEmpty()){
            Node node = p.poll();
            int cx = node.getX();
            int cy = node.getY();
            max = Math.max(max, node.getDis());

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && arr[nx][ny] == 'L'){
                    visited[nx][ny] = true;
                    p.add(new Node(nx, ny, node.getDis()+1));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'L'){
                    dp.add(new Node(i, j));
                }
            }
        }

        int rs = 0;
        for(Node node : dp){
            rs = Math.max(rs, bfs(node.getX(), node.getY()));
        }
        System.out.println(rs);




    }


}