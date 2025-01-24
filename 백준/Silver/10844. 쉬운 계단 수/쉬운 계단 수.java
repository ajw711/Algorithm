import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static long[][] dp;

    static long div= 1000000000L;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        for(int i=0; i<=9; i++){
            dp[1][i]=1L;
        }

        for (int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][1];
            for( int j=1; j<=9; j++){
                if (j==9){
                    dp[i][9] = dp[i-1][8]%div;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%div;
                }
            }
        }

        long cnt =0;
        for(int i=1; i<=9; i++){
            cnt = ( cnt + dp[N][i] ) %div;
        }
        System.out.println(cnt);



    }
}