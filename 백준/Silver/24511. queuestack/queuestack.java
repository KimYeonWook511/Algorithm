import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            if (stA.nextToken().charAt(0) == '0') deque.offerLast(Integer.parseInt(stB.nextToken()));
            else stB.nextToken();
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int run = 0; run < m; run++) {
            deque.offerFirst(Integer.parseInt(st.nextToken()));

            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb.toString());

        br.close();
    }
}