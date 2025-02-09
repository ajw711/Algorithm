import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int A, B;


    public static void main(String[] args) throws IOException {

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        System.out.println(A+B);

    }
}