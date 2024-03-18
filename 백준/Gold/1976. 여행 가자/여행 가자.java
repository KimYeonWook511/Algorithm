import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean flag = true;

        if (M != 0) {
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
    
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
    
                for (int c = 1; c <= r; c++) {
                    st.nextToken(); // 필요 없는 토큰 버리기
                }

                for (int c = r + 1; c <= N; c++) {
                    if (st.nextToken().charAt(0) == '1') union(r, c);
                }
            }
    
            st = new StringTokenizer(br.readLine());
            int root = find(Integer.parseInt(st.nextToken()));

            for (int i = 1; i < M; i++) {
                if (root != find(Integer.parseInt(st.nextToken()))) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag ? "YES" : "NO");

        br.close();
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}