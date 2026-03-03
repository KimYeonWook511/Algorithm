import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, h;

        Node (int i, int h) {
            this.i = i;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            long answer = 0;
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(new Node(-1, -1));
            for (int i = 0; i < n; i++) {
                int h = Integer.parseInt(st.nextToken());

                if (stack.peek().h < h) {
                    stack.push(new Node(i, h));
                } else {
                    Node lastNode = null;
                    while (stack.peek().h >= h) {
                        lastNode = stack.pop();
                        answer = Math.max(answer, (long)(i - lastNode.i) * lastNode.h);
                    }
                    stack.push(new Node(lastNode.i, h));
                }
            }

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                answer = Math.max(answer, (long)(n - node.i) * node.h);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}