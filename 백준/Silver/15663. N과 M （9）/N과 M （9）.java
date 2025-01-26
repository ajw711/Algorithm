import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr;


    static ArrayDeque<Integer> rs ;

    static boolean[] visited;

    static void dfs(int depth){

        if( depth == M){
            for(Integer num : rs){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }
        int prev = 0;
        for(int i=0; i< arr.length; i++){
            if(!visited[i] && prev!=arr[i]) {
                visited[i] = true;
                prev = arr[i];
                rs.add(arr[i]);
                dfs(depth + 1);
                rs.removeLast();
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rs = new ArrayDeque<>();


        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        dfs(0);




    }
}