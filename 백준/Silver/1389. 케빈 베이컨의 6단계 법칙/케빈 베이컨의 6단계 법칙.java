import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    private int index;
    private int cnt;

    public Node(int index, int cnt){
        this.index = index;
        this.cnt = cnt;
    }

    int getIndex(){
        return index;
    }

    int getCnt(){
        return cnt;
    }

}



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int min_value = Integer.MAX_VALUE;

    static int answer = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean [] visited;

    static void bfs(int start){

        ArrayDeque<Node> dp = new ArrayDeque<>();
        visited = new boolean[N+1];
        visited[start] = true;
        dp.add(new Node(start, 0));

        int rs = 0;

        while(!dp.isEmpty()){
            Node p = dp.poll();
            int index = p.getIndex();
            int cnt = p.getCnt();
            for(int next : list.get(index)){
                if(visited[next]){
                    continue;
                }
                rs = rs+cnt+1;
                visited[next] = true;
                dp.add(new Node(next, cnt+1));
            }
        }

        if(rs<min_value){
            min_value = rs;
            answer = start;
        }

    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }


        for(int i=1; i<=N; i++){
            bfs(i);
        }

        System.out.println(answer);
    }
}