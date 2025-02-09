import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int F, S, G, U, D;

    static int [] dy ;

    static int [] visited;
    static int cnt = Integer.MAX_VALUE;
    static int bfs(int start){
        ArrayDeque<Integer> dp = new ArrayDeque<>();
        dp.add(start);
        visited[start] = 0;


        while(!dp.isEmpty()){
            int cur = dp.poll();
            if(cur == G){
                return visited[cur];
            }
            for(int i=0; i<2; i++){
                int next = cur+dy[i];
                if(0<next && next <= F && visited[next] == -1){
                    visited[next] = visited[cur]+1;
                    dp.add(next);
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new int[F+1];
        Arrays.fill(visited, -1);
        dy = new int[2];
        dy[0] = U;
        dy[1] = -D;

        int answer = bfs(S);
        if(answer != -1){
            System.out.println(answer);
        }else{
            System.out.println("use the stairs");
        }

    }
}