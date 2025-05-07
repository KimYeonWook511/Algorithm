import java.io.*;
import java.util.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int arr[][] = new int[M][2];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i][0] = a;
                arr[i][1] = b;
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int o1[], int o2[]) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            parent = new int[N + 2];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            parent[N + 1] = N + 1; // 범위 초과 표시

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                int a = arr[i][0];
                int b = arr[i][1];

                int pointer = find(a);
                if (pointer <= b) {
                    // union
                    parent[pointer] = find(pointer + 1);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }
}