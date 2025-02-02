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
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M, N, K;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    static void init(int start_x, int start_y, int end_x, int end_y){

        for(int i=start_y; i<end_y; i++){
            for(int j=start_x; j<end_x; j++){
                visited[i][j] = true;
            }
        }
    }

    static int bfs(int start_x, int start_y){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start_x, start_y));
        visited[start_x][start_y] = true;
        int cnt = 1;


        while(!dp.isEmpty()){
            Node q = dp.poll();
            int cx = q.getX();
            int cy = q.getY();

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(0<=nx && nx<M && 0<=ny && ny<N && !visited[nx][ny]){
                    dp.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    cnt+=1;


                }

            }
        }

        return cnt;

    }



    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                visited[i][j] = false;
            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            init(start_x, start_y, end_x, end_y);
        }

        ArrayList<Integer> list =new ArrayList<>();

        int rs = 0;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    list.add(bfs(i, j));
                    rs+=1;
                }
            }
        }
        Collections.sort(list);

        System.out.println(rs);
        for(Integer num : list){
            System.out.print(num+" ");
        }




    }
}