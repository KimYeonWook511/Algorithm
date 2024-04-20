import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            if (left > right) {
                int temp = right;
                right = left;
                left = temp;
            }

            arr[i][0] = left;
            arr[i][1] = right;
        }

        int d = Integer.parseInt(br.readLine());

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);

                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        int max = 0;
        int size = 0;

        for (int i = n - 1; i >= 0; i--) {
            int left = arr[i][0];
            int right = arr[i][1];

            if (right - left > d) continue;

            pq.offer(right);
            size++;

            while (!pq.isEmpty()) {
                if (left >= pq.peek() - d) break;

                pq.poll();
                size--;
            }

            max = Math.max(max, size);
        }

        System.out.println(max);

        br.close();
    }
}