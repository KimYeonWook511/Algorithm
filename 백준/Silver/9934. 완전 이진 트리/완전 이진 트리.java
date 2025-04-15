import java.io.*;
import java.util.*;

public class Main {
    static int tree[], visited[];
    static int idx = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        tree = new int[(1 << K) - 1];
        visited = new int[(1 << K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.parseInt(st.nextToken());
        }

        find(0);

        int level = 1;
        for (int i = 0; i < tree.length; i++) {
            if (i == (1 << level) - 1) {
                sb.append("\n");
                level++;
            }
            
            sb.append(tree[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static void find(int cur) {
        int leftChildIdx = cur * 2 + 1;

        if (leftChildIdx < tree.length) {
            find(leftChildIdx);
        }

        tree[cur] = visited[idx++];

        if (leftChildIdx + 1 < tree.length) {
            find(leftChildIdx + 1);
        }
    }
}