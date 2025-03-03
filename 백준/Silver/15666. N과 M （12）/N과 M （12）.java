import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static int N, M;
    static int [] arr;
    static void dfs(int depth, int strat){

        if (depth == M){
            for(int num : stack){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = 0;
        for(int i=strat; i<N; i++){
            if(prev != arr[i]){
                prev = arr[i];
                stack.add(arr[i]);
                dfs(depth+1, i);
                stack.pop();

            }
        }
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);


    }



}