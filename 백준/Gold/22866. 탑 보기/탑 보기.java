import java.io.*;
import java.util.*;

public class Main {
    static class Building {
        int L, idx;

        Building (int L, int idx) {
            this.L = L;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        int cnt[] = new int[N + 1];
        int idx[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Building> deque = new ArrayDeque<>();
        deque.offer(new Building(100_001, -100_001));
        for (int i = 1; i <= N; i++) {
            while (deque.peekLast().L <= arr[i]) {
                deque.pollLast();
            }

            cnt[i] += deque.size() - 1;
            idx[i] = deque.peekLast().idx;

            deque.offer(new Building(arr[i], i));
        }

        deque.clear();
        deque.offer(new Building(100_001, 200_001));
        for (int i = N; i > 0; i--) {
            while (deque.peekLast().L <= arr[i]) {
                deque.pollLast();
            }

            cnt[i] += deque.size() - 1;
            if (i - idx[i] > deque.peekLast().idx - i) idx[i] = deque.peekLast().idx;

            deque.offer(new Building(arr[i], i));
        }

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) sb.append("0\n");
            else sb.append(cnt[i]).append(" ").append(idx[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}