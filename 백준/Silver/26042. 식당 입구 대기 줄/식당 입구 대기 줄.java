import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque();
		int cnt = 0;
		int num = 100000;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '2') {
                deque.poll();
                continue;
            }

            int temp = Integer.parseInt(st.nextToken());
            deque.add(temp);

            if (deque.size() < cnt) continue;

            if (deque.size() > cnt) {
                cnt = deque.size();
                num = temp;

            } else if (num > temp) {
                num = temp;
            }
		}

        System.out.println(cnt + " " + num);

        br.close();
    }
}