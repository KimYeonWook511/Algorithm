import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a + b - 1 > N) {
            sb.append("-1");
            
        } else if (a == 1) {
            sb.append(b).append(" ");

            for (int i = N - b; i >= 1; i--) {
                sb.append(1).append(" ");
            }

            for (int i = b - 1; i >= 1; i--) {
                sb.append(i).append(" ");
            }

        } else if (a < b) {
            for (int i = N - (a + b); i >= 0; i--) {
                sb.append(1).append(" ");
            }

            for (int i = 1; i < a; i++) {
                sb.append(i).append(" ");
            }

            for (int i = b; i >= 1; i--) {
                sb.append(i).append(" ");
            }

        } else {
            for (int i = N - (a + b); i >= 0; i--) {
                sb.append(1).append(" ");
            }

            for (int i = 1; i <= a; i++) {
                sb.append(i).append(" ");
            }

            for (int i = b - 1; i >= 1; i--) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}