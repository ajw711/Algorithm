
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    private int x;
    private int y;
    private int z;

    public Node(int z, int x, int y){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() {
        return z;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int H, N, M;
    static int rs;
    static int [][][] arr;
    static int [][][] visited;

    static int [] dx = {-1, 1, 0, 0, 0, 0};
    static int [] dy = {0, 0, -1, 1, 0, 0};
    static int [] dz = {0, 0, 0, 0, -1, 1};


    private static int bfs() {

        ArrayDeque<Node> dp = new ArrayDeque<>();


        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[k][i][j] == 1) {
                        dp.add(new Node(k, i, j));
                        visited[k][i][j] = 1;
                    }
                }
            }
        }

        rs = 0;


        while(!dp.isEmpty()){
            Node p =dp.poll();
            int cz = p.getZ();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<6; i++){
                int nz = cz + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0<=nz && nz<H && 0<=nx && nx<N && 0<=ny && ny<M && visited[nz][nx][ny] ==0 && arr[nz][nx][ny] == 0){
                    dp.add(new Node(nz, nx, ny));
                    visited[nz][nx][ny] = visited[cz][cx][cy] + 1;
                    arr[nz][nx][ny] = 1;
                    rs = Math.max(rs, visited[nz][nx][ny]);
                }

            }
        }


        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(visited[k][i][j] == 0 && arr[k][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }

        if (rs == 0){
            return 0;
        }

        return rs-1;

    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st  = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visited = new int[H][N][M];



        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs());

    }


}