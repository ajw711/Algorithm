import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    private int x;
    private int cnt;

    public Node(int x, int cnt){
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
    static int N, M ,K ,X;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> rs = new ArrayList<>();

    static boolean [] visited;
    static void bfs(int start){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start, 0));
        visited[start] = true;
        while(!dp.isEmpty()){
            Node p = dp.poll();
            int now = p.getX();
            int cnt = p.getCnt();
            if (cnt == K) {
                rs.add(now);
            }else if (cnt > K){
                return;
            }
            for(int i=0; i<list.get(now).size(); i++){
                int next = list.get(now).get(i);
                if(!visited[next]) {
                    dp.add(new Node(next, cnt + 1));
                    visited[next] = true;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
        }
        bfs(X);
        if(rs.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(rs);
            for(int num : rs){
                System.out.println(num);
            }
        }

    }



}