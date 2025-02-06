import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    static int start, end;

    static int x, y;

    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static Stack<Integer> stack = new Stack<>();

    static boolean check = false;

    static boolean[] visited ;

    static void dfs(int node) {

        if(node == end){
            System.out.println(stack.size());
            check = true;
        }


        for(int i=0; i<list.get(node).size(); i++){
            if(visited[list.get(node).get(i)]){
                continue;
            }
            visited[list.get(node).get(i)] = true;
            stack.add(list.get(node).get(i));
            dfs(list.get(node).get(i));
            stack.pop();
        }


    }




    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st =new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }


        dfs(start);
        if(!check){
            System.out.println(-1);
        }




    }
}