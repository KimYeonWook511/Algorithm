import java.io.*;
import java.util.*;

public class Main {
    static int arr[][], parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        arr = new int[N][3];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            // int y = Integer.parseInt(st.nextToken()); // 높이가 의미가 있는가?

            arr[i][0] = x1;
            arr[i][1] = x2;
            arr[i][2] = i + 1;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int xEnd = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (arr[i][0] > xEnd) {
                xEnd = arr[i][1];
                continue;
            }

            union(arr[i - 1][2], arr[i][2]);
            xEnd = Math.max(xEnd, arr[i][1]);
        }
        
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(find(A) == find(B) ? "1\n" : "0\n");
        }

        System.out.println(sb);
        
        br.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}