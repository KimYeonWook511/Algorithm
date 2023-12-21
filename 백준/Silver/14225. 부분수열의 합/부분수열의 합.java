import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        for (int i = 1; i <= 2000000; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static void func(int idx, int sum) {
        if (idx == N) {
            set.add(sum);   
            return;
        }

        func(idx + 1, sum + arr[idx]);
        func(idx + 1, sum);
    }
}