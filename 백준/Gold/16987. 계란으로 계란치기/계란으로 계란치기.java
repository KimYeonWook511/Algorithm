import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][], result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        System.out.println(result);

        br.close();
    }

    static void func(int idx, int cnt) {
        if (idx == N || cnt == N - 1) {
            result = Math.max(result, cnt);
            return;
        }

        if (arr[idx][0] > 0) {
            for (int next = 0; next < N; next++) {
                if (arr[next][0] <= 0) continue;
                if (next == idx) continue;

                arr[idx][0] -= arr[next][1];
                arr[next][0] -= arr[idx][1];
                func(idx + 1, cnt + (arr[idx][0] > 0 ? 0 : 1) + (arr[next][0] > 0 ? 0 : 1));
                arr[idx][0] += arr[next][1];
                arr[next][0] += arr[idx][1];
            }

        } else {
            func(idx + 1, cnt);
        }
    }
}