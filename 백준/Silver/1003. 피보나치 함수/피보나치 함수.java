import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;





    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[42][2];

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for(int i=0; i<N; i++){
            int num =Integer.parseInt(br.readLine());

            for(int j=2; j<=num; j++){
                arr[j][0] = arr[j-1][0]+arr[j-2][0];
                arr[j][1] = arr[j-1][1]+arr[j-2][1];

            }
            System.out.println(arr[num][0]+" "+arr[num][1]);

        }




    }
}