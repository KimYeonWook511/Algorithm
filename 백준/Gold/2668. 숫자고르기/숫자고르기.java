import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static int chk[];
    static int result[], idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        chk = new int[N + 1];
        result = new int[N + 1];
        idx = N;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }

        Arrays.sort(result);

        sb.append(N - idx).append("\n");
        for (int i = idx + 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
        
        br.close();
    }

    static int dfs(int i) {
        if (chk[i] == -1) return i;
        if (chk[i] != 0) return -2;

        chk[i] = -1;
        chk[i] = dfs(arr[i]);

        if (chk[i] == -2) return -2;

        result[idx--] = i;

        return chk[i] == i ? -2 : chk[i];
    }
}