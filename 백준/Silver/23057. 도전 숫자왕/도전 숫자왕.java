import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, total, arr[];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        func(0, 0);

        System.out.println(total - set.size());

        br.close();
    }

    static void func(int idx, int sum) {
        if (idx == N) return;

        for (int i = idx; i < N; i++) {
            set.add(sum + arr[i]);
            func(i + 1, sum + arr[i]);
        }
    }
}