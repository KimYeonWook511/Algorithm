import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static int chk[];
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        chk = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for (int num : result) {
            sb.append(num).append("\n");
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

        result.add(i);

        return chk[i] == i ? -2 : chk[i];
    }
}