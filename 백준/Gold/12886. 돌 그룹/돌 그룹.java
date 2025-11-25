import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int sum = A + B + C;

        boolean answer = false;
        if (sum % 3 == 0) {
            Deque<int[]> deque = new ArrayDeque<>();
            boolean visited[][] = new boolean[1501][1501];
            deque.offer(new int[]{A, B});
            visited[A][B] = true;
            visited[B][A] = true;

            while (!deque.isEmpty()) {
                int cur[] = deque.poll();
                int curA = cur[0];
                int curB = cur[1];
                int curC = sum - curA - curB;

                if (curA == curB && curB == curC) {
                    answer = true;
                    break;
                }
                
                // A, B
                if (curA != curB) {
                    int nextA = curA;
                    int nextB = curB;
                    if (curA > curB) {
                        nextA = curB;
                        nextB = curA;
                    }

                    nextB -= nextA;
                    nextA += nextA;

                    if (!visited[nextA][nextB]) {
                        deque.offer(new int[]{nextA, nextB});
                        visited[nextA][nextB] = true;
                        visited[nextB][nextA] = true;
                    }
                }

                // A, C
                if (curA != curC) {
                    int nextA = curA;
                    int nextC = curC;
                    if (curA > curC) {
                        nextA = curC;
                        nextC = curA;
                    }

                    nextC -= nextA;
                    nextA += nextA;

                    if (!visited[nextA][nextC]) {
                        deque.offer(new int[]{nextA, nextC});
                        visited[nextA][nextC] = true;
                        visited[nextC][nextA] = true;
                    }
                }

                // B, C
                if (curB != curC) {
                    int nextB = curB;
                    int nextC = curC;
                    if (curB > curC) {
                        nextB = curC;
                        nextC = curB;
                    }

                    nextC -= nextB;
                    nextB += nextB;
                    if (!visited[nextB][nextC]) {
                        deque.offer(new int[]{nextB, nextC});
                        visited[nextB][nextC] = true;
                        visited[nextC][nextB] = true;
                    }
                }
            }
        }

        System.out.println(answer ? 1 : 0);

        br.close();
    }
}