import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<String> queue[] = new Queue[N];
        for (int i = 0; i < N; i++) {
            queue[i] = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                queue[i].offer(st.nextToken());
            }
        }

        int count = N;
        boolean answer = true;
        StringTokenizer L = new StringTokenizer(br.readLine());
        while (L.hasMoreTokens()) {
            String str = L.nextToken();

            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (!queue[i].isEmpty() && queue[i].peek().equals(str)) {
                    flag = true;
                    queue[i].poll();

                    if (queue[i].isEmpty()) {
                        count--;
                    }

                    break;
                }
            }

            if (!flag) {
                answer = false;
                break;
            }
        }

        System.out.println(answer && count == 0 ? "Possible" : "Impossible");

        br.close();
    }
}
