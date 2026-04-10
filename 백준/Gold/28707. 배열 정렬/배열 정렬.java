import java.io.*;
import java.util.*;

public class Main {
    static class Command {
        int l, r, c;

        Command(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    static class Node {
        int num;
        int w;

        Node(int num, int w) {
            this.num = num;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        int count[] = new int[11];

        int start = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            count[A[i]]++;
            start *= 11; // 10진수가 아닌 11진수로 변경
            start += A[i];
        }

        int end = calEnd(count);
        int pow[] = calPow(N);

        int M = Integer.parseInt(br.readLine());
        Command commands[] = new Command[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            commands[i] = new Command(l, r, c);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        Map<Integer, Integer> dist = new HashMap<>();
        pq.offer(new Node(start, 0));
        dist.put(start, 0);

        int answer = -1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > dist.get(cur.num)) continue;

            if (cur.num == end) {
                answer = cur.w;
                break;
            }

            for (Command command : commands) {
                int l = command.l;
                int r = command.r;
                int c = command.c;

                int nextNum = swap(cur.num, l, r, pow);

                if (dist.getOrDefault(nextNum, Integer.MAX_VALUE) <= cur.w + c) continue;

                pq.offer(new Node(nextNum, cur.w + c));
                dist.put(nextNum, cur.w + c);
            }
        }

        System.out.println(answer);

        br.close();
    }

    static int calEnd(int count[]) {
        int num = 0;
        for (int i = 1; i <= 10; i++) {
            while (count[i] != 0) {
                num *= 11;
                num += i;
                count[i]--;
            }
        }
        return num;
    }

    static int[] calPow(int N) {
        int pow[] = new int[N + 1];
        pow[N] = 1;
        for (int i = N - 1; i >= 1; i--) {
            pow[i] = pow[i + 1] * 11;
        }
        return pow;
    }

    static int swap(int num, int l, int r, int pow[]) {
        int numl = num / pow[l] % 11;
        int numr = num / pow[r] % 11;

        num -= ((numl * pow[l]) + (numr * pow[r]));
        num += ((numr * pow[l]) + (numl * pow[r]));

        return num;
    }
}