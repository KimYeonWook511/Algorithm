import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int parent[] = new int[N];
        int cnt[] = new int[N]; // 자식 수
        List<Integer> list[] = new ArrayList[N]; // 자식들의 시간 리스트
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // 0번(root == 민식) 버리기
        for (int i = 1; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());

            cnt[parent[i]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (cnt[i] != 0) continue;

            deque.offer(i);
        }

        int dp[] = new int[N];
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            Collections.sort(list[cur]);
            for (int i = 0; i < list[cur].size(); i++) {
                dp[cur] = Math.max(dp[cur], list[cur].get(i) + list[cur].size() - i);
            }
            list[parent[cur]].add(dp[cur]);

            if (--cnt[parent[cur]] == 0) deque.offer(parent[cur]); // 민식이 cnt가 -1이 되어서 while문 끝남
        }

        System.out.println(dp[0]);

        br.close();
    }
}