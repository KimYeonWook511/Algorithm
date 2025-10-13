import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N * M];
        int arr[] = new int[N * M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                char ch = line.charAt(c);
                int val = r * M + c;

                if (ch == 'U') arr[val] = 0;
                else if (ch == 'R') arr[val] = 1;
                else if (ch == 'D') arr[val] = 2;
                else if (ch == 'L') arr[val] = 3;

                parent[val] = val;
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int val = r * M + c;
                int nr = r + dr[arr[val]];
                int nc = c + dc[arr[val]];

                union(val, nr * M + nc);
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int val = r * M + c;

                if (find(val) == val) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

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