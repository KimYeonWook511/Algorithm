import java.io.*;
import java.util.*;

public class Main {
    static class Rule {
        int start, end, diff;

        Rule (int start, int end, int diff) {
            this.start = start;
            this.end = end;
            this.diff = diff;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Rule rules[] = new Rule[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());

            rules[i] = new Rule(start, end, diff);
        }

        int left = 0;
        int right = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            long cnt = func(mid, rules);

            if (cnt < D) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);

        br.close();
    }

    static long func(int mid, Rule[] rules) {
        long cnt = 0;
        for (Rule rule : rules) {
            if (rule.start > mid) continue;

            int end = Math.min(mid, rule.end);
            cnt += ((end - rule.start) / rule.diff) + 1;
        }
        return cnt;
    }
}