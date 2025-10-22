import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int LOG = 1;
        while ((1 << LOG) <= N) {
            LOG++;
        }
        int next[][] = new int[LOG][N]; // v에서부터 2^k개까지의 최솟값
        for (int v = 0; v < N; v++) {
            next[0][v] = arr[v];
        }
        for (int k = 1; k < LOG; k++) {
            int range = 1 << k;
            for (int v = N - range; v >= 0; v--) {
                // left, right의 최소를 확인함 -> k=3,v=0이라면 next[3][0] = next[2][0] + next[2][0+4] (2^2=4개씩 나눠서)
                next[k][v] = Math.min(next[k - 1][v], next[k - 1][v + (range / 2)]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int len = b - a + 1;
            int k = 31 - Integer.numberOfLeadingZeros(len); // int는 32bit -> 2^31까지 -> 31 - (맨 앞 0비트의 개수) == len의 최상위 1의 비트 자리
            sb.append(Math.min(next[k][a], next[k][b - (1 << k) + 1])).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}