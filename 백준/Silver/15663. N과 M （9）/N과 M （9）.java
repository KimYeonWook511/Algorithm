import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[], result[];
    static boolean chk[];
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        chk = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        func(0);

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int idx) {
        if (idx == M) {
            temp = new StringBuilder();

            for (int num : result) {
                temp.append(num).append(" ");
            }

            if (set.add(temp.toString())) sb.append(temp).append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (chk[i]) continue;

            chk[i] = true;
            result[idx] = arr[i];
            func(idx + 1);
            chk[i] = false;
        }
    }
}