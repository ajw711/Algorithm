import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, H;
    static int [] arr1;
    static int [] arr2;

    static int binarySearch(int start ,int end, int h, int [] arr){

       while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] >= h){
                end = mid;
            }else{
                start = mid+1;
            }
       }
       return arr.length - end;
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr1 = new int [N/2];
        arr2 = new int [N/2];

        for(int i=0; i<N/2; i++){
            arr1[i] = Integer.parseInt(br.readLine());
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int min_value = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i=1; i<=H; i++){
            int sum =  binarySearch(0, N/2, i, arr1) + binarySearch(0, N/2, H-i+1, arr2);

            if( min_value == sum){
                cnt+=1;
                continue;
            }
            if(min_value > sum){
                min_value = sum;
                cnt = 1;
            }
        }

        System.out.println(min_value + " " + cnt);



    }


}