import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> leftQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();

        leftQ.offer(-10001);
        rightQ.offer(10001);

        int n = Integer.parseInt(br.readLine());

        for (int run = 0; run < n; run++) {
            int num = Integer.parseInt(br.readLine());

            if (num > rightQ.peek()) rightQ.offer(num);
            else leftQ.offer(num);

            if (leftQ.size() > rightQ.size() + 1) rightQ.offer(leftQ.poll());
            else if (leftQ.size() < rightQ.size()) leftQ.offer(rightQ.poll());

            sb.append(leftQ.peek()).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}