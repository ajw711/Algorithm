import java.util.*;
import java.io.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static boolean isPrime(int num) {
        if(num <2) 
            return false;
        for(int i=2 ; i*i<=num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int num, int depth){
        if( depth == 0 ) {
            System.out.println(num);
        }
        for(int i=1; i<10; i++){
            int next = num * 10 + i;
            if(isPrime(next)){
                dfs(next, depth-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] startPrimes = {2, 3, 5, 7};
        for (int num : startPrimes) {
            dfs(num, n-1);  
        }
    }

}