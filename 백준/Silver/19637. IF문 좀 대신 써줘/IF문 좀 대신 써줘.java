import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String name[] = new String[N];
        int power[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int run = 0; run < M; run++) {
            int p = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (p <= power[mid]) right = mid - 1;
                else left = mid + 1;
            }

            sb.append(name[right + 1]).append("\n");
        }
        
        System.out.println(sb.toString());

        br.close();
    }
}