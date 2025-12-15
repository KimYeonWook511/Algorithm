import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int answer = 0;
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            int ch = line.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else { // ')'
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    answer = Math.max(answer, i - stack.peek());
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}