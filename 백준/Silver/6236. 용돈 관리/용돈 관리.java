import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int [] arr;
    //통장에서 K원을 인출
    // 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 통장에 집어넣고 다시 K원을 인출할 수 있다.
    // 남은 금액이 600원 하루 사용할 금액이 500원이면 600원을 다시 통장에 넣는다.
    static int binarySearch(int start , int end, int target) {

        // 100 100 101 300 400 400 500 sum = 1901
        int result = end;

        while (start <= end) {
            int cnt = 1;
            int mid = (start + end) / 2;
            int k = arr[0];
            for (int i = 1; i < N; i++) {
                if (k+arr[i] > mid) {
                    // 만약 mid 즉 k원이 해당 요일에 인출 금액보다 작으면 다시 넣어야함
                    cnt += 1;
                    k = 0;
                }
                k += arr[i];

            }

            if (cnt <= target) {
                result = Math.min(mid, result);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
         }

        return result;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int end = 0;
        int start = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            end +=arr[i];
            start = Math.max(start, arr[i]);
        }
        System.out.println(binarySearch(start, end, M));
    }



}