import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K, N; // 랜선 개수, 필요한 랜선 개수
    static int[] LAN;

    static long binarySearch(int[] arr, int target) {
        long start = 1; // 최소 길이 1로 변경
        long end = Arrays.stream(arr).max().getAsInt(); // 최대 길이
        long rs = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            // 현재 길이로 잘랐을 때 만들 수 있는 랜선의 개수
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] / mid;
            }

            // 랜선 개수가 목표 이상이면 길이를 늘림
            if (sum >= target) {
                rs = mid;
                start = mid + 1;
            } else { // 랜선 개수가 목표 미달이면 길이를 줄임
                end = mid - 1;
            }
        }
        return rs;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        LAN = new int[K];

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            LAN[i] = num;
        }

        // 정렬은 필요 없음 (최대값만 사용)
        System.out.println(binarySearch(LAN, N));
    }
}
