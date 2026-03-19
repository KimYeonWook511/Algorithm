import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][N];
        int answer = 0;
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                answer += arr[r][c];
            }
        }
        answer >>= 1; // 두 번 합해진거 처리

        boolean chk[][] = new boolean[N][N];
        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (s == m) continue;

                for (int e = 0; e < N; e++) {
                    if (m == e || s == e) continue;

                    // 이상한 경우
                    if (arr[s][e] > arr[s][m] + arr[m][e]) {
                        answer = -1;
                        s = N;
                        m = N;
                        break; // e = N;
                    }

                    // 중간 경유해서 가는 경우
                    if (arr[s][e] == arr[s][m] + arr[m][e]) {
                        if (!chk[s][e]) {
                            answer -= arr[s][e];
                            chk[s][e] = true;
                            chk[e][s] = true;
                        }
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}