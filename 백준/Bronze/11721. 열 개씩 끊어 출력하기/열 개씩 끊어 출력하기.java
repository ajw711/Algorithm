
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        String s = br.readLine();
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++){
            System.out.print(c[i]);
            if (i % 10 == 9) {
                System.out.println();
            }
        }


    }


}