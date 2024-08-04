import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int cnt[] = new int[1_000_001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            cnt[A[i]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int result[] = new int[N];

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty()) {
                if (cnt[A[i]] <= cnt[A[deque.peekLast()]]) break;

                result[deque.pollLast()] = A[i];
            }

            deque.offerLast(i);
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(result[i] == 0 ? "-1" : result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}