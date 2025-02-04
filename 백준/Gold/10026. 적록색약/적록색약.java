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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] arr;
    static char[][] arr2;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};


    static void bfs(int start_x, int start_y, char[][] rgb, boolean[][] check){

        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start_x, start_y));
        check[start_x][start_y] = true;
        char color = rgb[start_x][start_y];

        while(!dp.isEmpty()){

            Node p = dp.poll();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<N && !check[nx][ny] && color==rgb[nx][ny]){
                    dp.add(new Node(nx, ny));
                    check[nx][ny] = true;
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        arr2 = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];



        for(int i=0; i<N; i++) {
            String s = br.readLine();
            Arrays.fill(visited[i], false);
            Arrays.fill(visited2[i], false);

            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                if (s.charAt(j) == 'G') {
                    arr2[i][j] = 'R';
                } else {
                    arr2[i][j] = s.charAt(j);
                }
            }
        }


        int cnt =0;
        int cnt2 = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i, j, arr, visited);
                    cnt+=1;
                }

                if(!visited2[i][j]){
                    bfs(i, j, arr2, visited2);
                    cnt2+=1;
                }
            }
        }

        System.out.println(cnt+" "+cnt2);
    }
}