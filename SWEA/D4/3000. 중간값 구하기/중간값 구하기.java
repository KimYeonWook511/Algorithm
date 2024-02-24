import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1, o2);
                }
            });
            PriorityQueue<Integer> right = new PriorityQueue<>();
            right.offer(A);

            int sum = 0;

            for (int run = 0; run < N; run++) {
                st = new StringTokenizer(br.readLine());

                right.offer(Integer.parseInt(st.nextToken()));
                left.offer(right.poll());

                right.offer(Integer.parseInt(st.nextToken()));
                left.offer(right.poll());

                right.offer(left.poll());

                sum = (sum + right.peek()) % 20171109;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}