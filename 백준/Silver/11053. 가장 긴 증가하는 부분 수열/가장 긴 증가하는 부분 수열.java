import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] arr;
    static int[] dp;



    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        arr[0] = 0;
        dp[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=N; i++){
            int cnt = 0;
            for (int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = cnt+1;
        }

        int rs = Arrays.stream(dp).max().getAsInt();

        System.out.println(rs);


    }
}