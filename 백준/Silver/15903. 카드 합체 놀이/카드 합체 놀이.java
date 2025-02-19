
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static PriorityQueue<Long> minHeap = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            minHeap.offer(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            long num1= minHeap.poll();
            long num2= minHeap.poll();
            long sum = num1+num2;
            minHeap.offer(sum);
            minHeap.offer(sum);
        }

        long result = 0;
        while(!minHeap.isEmpty()){
            result +=minHeap.poll();
        }
        System.out.println(result);



    }


}