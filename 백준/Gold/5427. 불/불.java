import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

class Node{
    private final int x;
    private final int y;

    private final int flag;

    private Node(int x, int y, int flag){
        this.x = x;
        this.y = y;
        this.flag = flag;
    }

    public static Node of(int x, int y, int flag) {
        return new Node(x, y, flag);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFlag() {
        return flag;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, M;
    static char[][] arr;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int [][] visited;
    static ArrayList<Node> fire;

    static int bfs(int start_x, int start_y){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        // 불
        for(Node node : fire){
            int x = node.getX();
            int y = node.getY();
            dp.add(Node.of(x,y, 1));
            visited[x][y] = -1;
        }

        dp.add(Node.of(start_x, start_y, 0)); // 상근이
        visited[start_x][start_y] = 1;

        while(!dp.isEmpty()){
            int size = dp.size();

            for(int i=0; i<size; i++){
                Node p = dp.poll();
                int cx = p.getX();
                int cy = p.getY();
                int flag = p.getFlag();

                for(int j=0; j<4; j++){
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    if( flag == 0 && (nx < 0 || nx >= M || ny < 0 || ny >= N)){
                        return visited[cx][cy];
                    }

                    if(0<=nx && nx < M && 0<=ny && ny<N  && arr[nx][ny] == '.'){
                        if(arr[cx][cy] == '@' && flag == 0 && visited[nx][ny] == 0){
                            dp.add(Node.of(nx, ny, 0));
                            visited[nx][ny] = visited[cx][cy] + 1;
                            arr[nx][ny] = '@';
                        }else if(arr[cx][cy] == '*' && flag == 1 && visited[nx][ny] == 0){
                            dp.add(Node.of(nx, ny, 1));
                            arr[nx][ny] = '*';
                            visited[nx][ny] = -1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[M][N];
            visited = new int[M][N];

            fire = new ArrayList<>();

            int start_x = 0;
            int start_y = 0;

            // 상근 위치
            // 불들 위치

            for(int x=0; x<M; x++){
                String s= br.readLine();
                for(int y=0; y<N; y++){
                    arr[x][y] = s.charAt(y);

                    if(arr[x][y] == '@'){
                        start_x = x;
                        start_y = y;
                    }else if(arr[x][y] == '*'){
                        fire.add(Node.of(x, y, 1));
                    }
                }
            }

           int result = bfs(start_x, start_y);
            if(result != -1){
                System.out.println(result);
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }

    }



}