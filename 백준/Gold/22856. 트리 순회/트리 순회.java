import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i;
        Node leftChild;
        Node rightChild;

        Node (int i) {
            this.i = i;
        }
    }
    static int N;
    static Node nodes[];
    static int answer, cnt, visitedNodeCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b != -1) {
                nodes[a].leftChild = nodes[b];
            }
            if (c != -1) {
                nodes[a].rightChild = nodes[c];
            }
        }

        dfs(1, false);

        System.out.println(answer);

        br.close();
    }

    static void dfs(int i, boolean isBack) {
        Node cur = nodes[i];
        visitedNodeCount++;

        if (cur.leftChild != null) {
            cnt++;
            dfs(cur.leftChild.i, true);
        }

        if (cur.rightChild != null) {
            cnt++;
            dfs(cur.rightChild.i, isBack);
        }

        if (visitedNodeCount == N && !isBack) {
            answer = cnt;
            return;
        }

        cnt++;
    }
}