import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long nums[] = new long[N];
        Map<Long, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            nums[i] = Long.parseLong(input, 2);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int K = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int zeroCount = M - Long.bitCount(nums[i]);

            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                answer = Math.max(answer, count.get(nums[i]));
            }
        }

        System.out.println(answer);

        br.close();
    }
}