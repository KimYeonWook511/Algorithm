import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cnt, A, B;

        Node (int cnt, int A, int B) {
            this.cnt = cnt;
            this.A = A;
            this.B = B;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;

        int L = Integer.parseInt(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();
        int dp[][][] = new int[L + 1][N][N]; // 0은 아직 가지 않은 경우
        deque.offer(new Node(1, A, B)); // 시작을 1로해서 나중에 -1 해서 정답 출력하기
        dp[0][A][B] = 1;

        for (int i = 0; i < L; i++) {
            int target = Integer.parseInt(br.readLine()) - 1;

            for (int k = deque.size(); k > 0; k--) {
                Node cur = deque.poll();

                if (cur.cnt > dp[i][cur.A][cur.B]) continue;

                int moveA = Math.abs(cur.A - target);
                int moveB = Math.abs(cur.B - target);

                if (dp[i + 1][target][cur.B] == 0 || dp[i + 1][target][cur.B] > cur.cnt + moveA) {
                    deque.offer(new Node(cur.cnt + moveA, target, cur.B));
                    dp[i + 1][target][cur.B] = dp[i + 1][cur.B][target] = cur.cnt + moveA;
                }

                if (dp[i + 1][cur.A][target] == 0 || dp[i + 1][cur.A][target] > cur.cnt + moveB) {
                    deque.offer(new Node(cur.cnt + moveB, cur.A, target));
                    dp[i + 1][cur.A][target] = dp[i + 1][target][cur.A] = cur.cnt + moveB;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            result = Math.min(result, deque.poll().cnt);
        }

        System.out.println(result - 1);

        br.close();
    }
}