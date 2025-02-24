import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[K];
        Deque<Integer> idx[] = new ArrayDeque[K + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (idx[arr[i]] == null) idx[arr[i]] = new ArrayDeque<>();
            else idx[arr[i]].offer(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -Integer.compare(o1[1], o2[1]);
            }
        });
        boolean chk[] = new boolean[K + 1];

        int result = 0;
        for (int i = 0; i < K; i++) {
            if (chk[arr[i]]) N++;

            if (pq.size() >= N) {
                chk[pq.poll()[0]] = false;
                result++;
            }

            pq.offer(new int[]{arr[i], idx[arr[i]].isEmpty() ? K : idx[arr[i]].poll()});
            chk[arr[i]] = true;
        }

        System.out.println(result);

        br.close();
    }
}