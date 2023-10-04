import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int run = 0; run < t; run++) {
            PriorityQueue<Integer> leftQ = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            PriorityQueue<Integer> rightQ = new PriorityQueue<>();

            int m = Integer.parseInt(br.readLine());

            sb.append((m + 1) / 2);

            for (int k = 0; k < m; k += 10) {
                if (k % 20 == 0) sb.append("\n");

                String arr[] = br.readLine().split(" ");

                for (int i = 0; i < arr.length; i++) {
                    int num = Integer.parseInt(arr[i]);

                    if (rightQ.size() != 0 && num > rightQ.peek()) rightQ.offer(num);
                    else leftQ.offer(num);

                    if (leftQ.size() > rightQ.size() + 1) rightQ.offer(leftQ.poll());
                    else if (leftQ.size() < rightQ.size()) leftQ.offer(rightQ.poll());

                    if (i % 2 == 0) sb.append(leftQ.peek()).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}