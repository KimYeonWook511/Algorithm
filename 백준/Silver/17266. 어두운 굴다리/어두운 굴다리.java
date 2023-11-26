import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = Integer.parseInt(st.nextToken());
        int left = temp;

        for (int i = 1; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            left = Math.max(left, (x - temp + 1) / 2);

            temp = x;
        }

        System.out.println(Math.max(left, (N - temp)));
        
        br.close();
    }
}