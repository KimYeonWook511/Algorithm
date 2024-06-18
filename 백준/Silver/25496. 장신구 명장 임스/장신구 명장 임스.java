import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[201];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int cnt = 0;
        for (int i = 1; i <= 200; i++) {
            if (arr[i] == 0) continue;

            if (P >= 200) break;

            P += i;
            cnt++;
            arr[i]--;
            i--;
        }

        System.out.println(cnt);

        br.close();
    }
}