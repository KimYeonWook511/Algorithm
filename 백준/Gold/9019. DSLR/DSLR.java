import java.io.*;
import java.util.*;

public class Main {
    static class Case {
        int num, cnt;
        StringBuilder sb;

        Case (int num, int cnt, StringBuilder sb) {
            this.num = num;
            this.cnt = cnt;
            this.sb = sb;
        }
    }
    static char cmd[] = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Deque<Case> deque = new ArrayDeque<>();
            boolean chk[] = new boolean[10001];
            deque.offer(new Case(A, 0, new StringBuilder()));
            chk[A] = true;

            while (true) { // 무조건 정답이 나옴
                Case cur = deque.poll();

                if (cur.num == B) {
                    sb.append(cur.sb).append("\n");
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int val = cal(cur.num, d);

                    if (chk[val]) continue;

                    deque.offer(new Case(val, cur.cnt + 1, new StringBuilder(cur.sb).append(cmd[d])));
                    chk[val] = true;
                }
            }
        }

        System.out.println(sb);

        br.close();
    }

    static int cal(int num, int d) {
        if (d == 0) num = (num << 1) % 10000;
        else if (d == 1) num = (num + 9999) % 10000;
        else if (d == 2) num = num % 1000 * 10 + num / 1000;
        else num = num % 10 * 1000 + num / 10;
        
        return num;
    }
}