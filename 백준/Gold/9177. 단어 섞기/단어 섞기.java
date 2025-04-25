import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            String target = st.nextToken();

            Deque<int[]> deque = new ArrayDeque<>();
            boolean chk[][] = new boolean[str1.length() + 1][str2.length() + 1];
            deque.offer(new int[]{0, 0, 0});

            boolean flag = false;
            while (!deque.isEmpty()) {
                int cur[] = deque.poll();
                
                if (cur[2] == target.length()) {
                    flag = true;
                    break;
                }

                if (cur[0] < str1.length() && !chk[cur[0] + 1][cur[1]] && str1.charAt(cur[0]) == target.charAt(cur[2])) {
                    deque.offer(new int[]{cur[0] + 1, cur[1], cur[2] + 1});
                    chk[cur[0] + 1][cur[1]] = true;
                }

                if (cur[1] < str2.length() && !chk[cur[0]][cur[1] + 1] && str2.charAt(cur[1]) == target.charAt(cur[2])) {
                    deque.offer(new int[]{cur[0], cur[1] + 1, cur[2] + 1});
                    chk[cur[0]][cur[1]] = true;
                }
            }

            sb.append("Data set ").append(i).append(": ").append(flag ? "yes\n" : "no\n");
        }

        System.out.println(sb);

        br.close();
    }
}