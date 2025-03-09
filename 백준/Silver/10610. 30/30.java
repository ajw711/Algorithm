import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        s = br.readLine();
        char [] c =s.toCharArray();
        Arrays.sort(c);

        int sum  = 0;
        for(int i=c.length-1; i>=0; i--){
            int num = c[i] - '0';
            sum += num;
            sb.append(num);
        }

        if( (sum%3) != 0 || c[0] !='0'){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }


    }



}