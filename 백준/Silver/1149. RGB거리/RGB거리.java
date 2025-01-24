import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] arr;
    static int[][] dp;



    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][3];
        dp = new int[N+1][3];
        arr[0][0] = arr[0][1] = arr[0][2] = 0;


        for (int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N; i++){
                dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = arr[i][1] +Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = arr[i][2] +Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int rs = Arrays.stream(dp[N]).min().getAsInt();
        System.out.println(rs);




    }
}