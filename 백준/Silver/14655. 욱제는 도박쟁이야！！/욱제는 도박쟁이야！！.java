import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            result += Math.abs(Integer.parseInt(st1.nextToken())) + Math.abs(Integer.parseInt(st2.nextToken()));
        }

		System.out.println(result);

        br.close();
    }
}