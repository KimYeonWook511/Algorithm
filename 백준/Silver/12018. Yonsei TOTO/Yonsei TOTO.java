import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        int P, L, point[];

        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            if (P < L) {
                arr[run] = 1;

            } else {
                point = new int[P];
    
                for (int i = 0; i < P; i++) {
                    point[i] = Integer.parseInt(st.nextToken());
                }
    
                Arrays.sort(point);

                arr[run] = point[P - L];
            }
        }

        Arrays.sort(arr);

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            m -= arr[i];

            if (m < 0) break;

            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}