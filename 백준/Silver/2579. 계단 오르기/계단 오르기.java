import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] arr;
    static int[][] dp;




    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int [N+1];
        dp = new int[N+1][3];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            for (int j=0; j<3; j++){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = dp[i-1][0] + arr[i];
                dp[i][2] = dp[i-1][1] + arr[i];
            }
        }
        System.out.println(Math.max(dp[N][1], dp[N][2]));



    }
}