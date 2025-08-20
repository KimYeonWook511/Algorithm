import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, temp, val;
        char op;
        Node pre;

        Node (int i, int temp, int val, char op, Node pre) {
            this.i = i;
            this.temp = temp;
            this.val = val;
            this.op = op;
            this.pre = pre;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            Deque<Node> deque = new ArrayDeque<>();
            deque.offer(new Node(1, 1, 0, ' ', null));

            while (!deque.isEmpty()) {
                Node cur = deque.poll();

                if (cur.i == N) {
                    if (cur.val + cur.temp == 0) {
                        StringBuilder sb2 = new StringBuilder();
                        while (cur.pre != null) {
                            sb2.append(cur.i).append(cur.op);
                            cur = cur.pre;
                        }
                        sb2.append(1);

                        sb.append(sb2.reverse()).append("\n");
                    }
                    
                    continue;
                }

                int next = cur.i + 1;

                // " "
                deque.offer(new Node(next, cur.temp * 10 + (cur.temp > 0 ? next : -next), cur.val, ' ', cur));
    
                // "+"
                deque.offer(new Node(next, next, cur.val + cur.temp, '+', cur));
    
                // "-"
                deque.offer(new Node(next, -next, cur.val + cur.temp, '-', cur));
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}