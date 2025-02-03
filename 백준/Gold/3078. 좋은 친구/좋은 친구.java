import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        int cnt[] = new int[21];
        long result = 0;
        deque.offer(0);

        for (int i = 1; i < K; i++) {
            int len = br.readLine().length();

            result += cnt[len];

            deque.offer(len);
            cnt[len]++;
        }

        for (int i = K; i <= N; i++) {
            int len = br.readLine().length();

            result += cnt[len];

            deque.offer(len);
            cnt[len]++;

            cnt[deque.poll()]--;
        }

        System.out.println(result);

        br.close();
    }
}