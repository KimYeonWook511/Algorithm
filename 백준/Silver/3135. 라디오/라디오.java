import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = Math.abs(A - B);

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            min = Math.min(min, Math.abs(Integer.parseInt(br.readLine()) - B) + 1);
        }

        System.out.println(min);

        br.close();
    }
}