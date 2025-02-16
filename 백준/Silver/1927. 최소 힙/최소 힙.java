
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(minHeap.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(minHeap.poll());
                }
            }else{
                minHeap.offer(num);
            }

        }

    }


}