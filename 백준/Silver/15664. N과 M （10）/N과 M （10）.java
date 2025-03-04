import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int [] arr;
    static boolean [] visited;
    static Stack<Integer> stack = new Stack<>();

    static void dfs(int depth, int start){

        if(depth == M){
            for(int num : stack){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        int pre = 0;
        for(int i=start; i<N; i++){
            if(pre != arr[i] && !visited[i]) {
                pre = arr[i];
                visited[i] = true;
                stack.add(arr[i]);
                dfs(depth + 1, i);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);

    }



}