
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //회전 초밥 연속으로 k개를 먹고 ( 그 대신 연속 x 서로 다른 숫자 o)
    // 쿠폰 사용시 해당 쿠폰 번호 초밥 먹고 그 후 연속으로 진행 혹은 연속먹고 해당 쿠폰 사용
    // 만약에 쿠폰 해당 번호 초밥이 없으면 요리사가 제공해준다.

    static int N, d, k, c;
    static int [] arr;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max_sushi = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }

        for(int i=0; i<N; i++){
            int eat = 1;
            int [] check = new int[d+1];
            check[c] = 1;
            for(int j=i; j <(i+k); j++){
                int sushi = arr[j%N];

                if(check[sushi] == 0){
                    eat +=1;
                }
                check[sushi] +=1;
            }
            max_sushi = Math.max(max_sushi, eat);
        }

        System.out.println(max_sushi);


    }


}