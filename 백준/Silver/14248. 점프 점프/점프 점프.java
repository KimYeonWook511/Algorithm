import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];
        deque.offer(s);
        visited[s] = true;

        int answer = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            answer++;

            // left
            if (cur - arr[cur] > 0 && !visited[cur - arr[cur]]) {
                deque.offer(cur - arr[cur]);
                visited[cur - arr[cur]] = true;
            }
            // right
            if (cur + arr[cur] <= n && !visited[cur + arr[cur]]) {
                deque.offer(cur + arr[cur]);
                visited[cur + arr[cur]] = true;
            }
        }

        System.out.println(answer);

        br.close();
    }
}