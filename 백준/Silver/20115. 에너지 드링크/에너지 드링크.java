import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double result = 0;
        int max = 0;

        for (int run = 0; run < N; run++) {
            int num = Integer.parseInt(st.nextToken());

            max = Math.max(max, num);

            result += num;
        }

        System.out.println((result + max) / 2.0);

        br.close();
    }
}