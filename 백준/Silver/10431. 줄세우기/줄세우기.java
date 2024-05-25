import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
		
        for (int run = 1; run < P + 1; run++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int cnt = 0;
            int num[] = new int[20];

            for (int i = 0; i < 20; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 20; i++) {
                for (int k = 0; k < i; k++) {
                    if (num[k] > num[i]) cnt++;
                }
            }

            sb.append(run).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}