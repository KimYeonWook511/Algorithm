import java.io.*;
import java.util.*;

public class Main {
    static Deque<int[]> deque = new ArrayDeque<>();
    static Set<Integer> visited = new HashSet<>();
    static final int POW[] = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start[] = new int[3];
        for (int r = 0; r < 3; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < 3; c++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 0) start[0] = r * 3 + c;

                start[1] = (start[1] * 10) + num;
            }
        }
        deque.offer(start);
        visited.add(start[1]);

        int result = -1;
        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            // cur[1] == 123456780인지 확인
            if (cur[1] == 123456780) {
                result = cur[2];
                break;
            }

            // up
            if (cur[0] - 3 >= 0) swap(cur[0] - 3, cur[1], cur[2], 8 - cur[0]);

            // down
            if (cur[0] + 3 < 9) swap(cur[0] + 3, cur[1], cur[2], 8 - cur[0]);

            // right
            if ((cur[0] + 1) % 3 != 0) swap(cur[0] + 1, cur[1], cur[2], 8 - cur[0]);

            // left
            if (cur[0] % 3 != 0) swap(cur[0] - 1, cur[1] , cur[2], 8 - cur[0]);
        }

        System.out.println(result);

        br.close();
    }

    static void swap(int nIdx, int preNum, int cnt, int zeroIdx) {
        int num = (preNum % POW[8 - nIdx + 1]) / POW[8 - nIdx];

        int nextNum = preNum - (num * POW[8 - nIdx]); // 다음 위치 빼기
        nextNum += num * POW[zeroIdx]; // zero위치 만큼 더하기

        if (!visited.contains(nextNum)) {
            deque.offer(new int[]{nIdx, nextNum, cnt + 1});
            visited.add(nextNum);
        }
    }
}
