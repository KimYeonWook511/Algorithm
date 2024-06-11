import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[i][0] = d;
            arr[i][1] = w;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return -Integer.compare(o1[1], o2[1]);

                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (pq.size() < arr[i][0]) {
                sum += arr[i][1];
                pq.offer(arr[i][1]);
                continue;
            }

            if (pq.peek() >= arr[i][1]) continue;

            sum -= pq.poll();
            sum += arr[i][1];
            pq.offer(arr[i][1]);
        }

        System.out.println(sum);

        br.close();
    }
}