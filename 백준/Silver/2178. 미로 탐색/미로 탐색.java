import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
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
    static int[][] adj;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int start_x, int start_y, int end_x, int end_y) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(start_x, start_y));
        visited[start_x][start_y] = 1;

        while (!deque.isEmpty()) {
            Node c = deque.poll();
            int cx = c.getX();
            int cy = c.getY();

            if (end_x == cx && end_y == cy) {
                System.out.println(visited[end_x][end_y]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (adj[nx][ny] == 1 && visited[nx][ny] == 0) { // 방문 여부 체크
                        deque.add(new Node(nx, ny));
                        visited[nx][ny] = visited[cx][cy] + 1; // 방문 처리
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                adj[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0, N - 1, M - 1);
    }
}
