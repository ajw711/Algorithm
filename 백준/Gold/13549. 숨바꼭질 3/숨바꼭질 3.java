import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

class Node {
    private int x;
    private int cnt;

    public Node(int x ,int cnt){
        this.x = x;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getCnt() {
        return cnt;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;

    static void bfs(int start){
        boolean[] visited = new boolean[100001];
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start, 0));
        visited[start] = true;

        while (!dp.isEmpty()){
            Node p = dp.poll();
            int cx = p.getX();
            int now_cnt = p.getCnt();
            visited[cx] = true;
            if (cx == K) {
                System.out.println(now_cnt);
                return;
            }

            if (cx * 2 <= 100000 && !visited[cx * 2]) {
                    dp.add(new Node(cx*2 , now_cnt));
            }
            if (cx - 1 >= 0 && !visited[cx - 1]) {
                dp.add(new Node(cx-1 , now_cnt+1));
            }
            if (cx + 1 <= 100000 && !visited[cx + 1]) {
                dp.add(new Node(cx+1 , now_cnt+1));
            }
         

        }

    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);

    }



}