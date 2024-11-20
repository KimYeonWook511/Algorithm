import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        int arr[] = new int[N];
        int time = 0;
        int cur[];
        int temp;
        while (!deque.isEmpty()) {
            time++;
            cur = deque.poll();
            temp = cur[1] - 1;

            if (temp == 0) arr[cur[0]] = time;
            else deque.offer(new int[]{cur[0], temp});
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}