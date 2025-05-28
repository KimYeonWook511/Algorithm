import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Node leftChild, rightChild;

        Node (Node leftNode, Node rightNode) {
            this.leftChild = leftNode;
            this.rightChild = rightNode;
        }
    }

    static Node tree[];
    static int levelWidth[];
    static int col = 1;
    static int result[] = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        levelWidth = new int[N + 1];
        boolean isNotRoot[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new Node(null, null);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());

            if (leftChild != -1) {
                tree[cur].leftChild = tree[leftChild];
                isNotRoot[leftChild] = true;
            }

            if (rightChild != -1) {
                tree[cur].rightChild = tree[rightChild];
                isNotRoot[rightChild] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isNotRoot[i]) continue;

            find(tree[i], 1);
            break;
        }

        System.out.println(result[0] + " " + result[1]);

        br.close();
    }

    static void find(Node cur, int level) {
        if (cur.leftChild != null) find(cur.leftChild, level + 1);

        if (levelWidth[level] == 0) levelWidth[level] = col;
        resultRefresh(col - levelWidth[level] + 1, level);
        col++;

        if (cur.rightChild != null) find(cur.rightChild, level + 1);
    }

    static void resultRefresh(int width, int level) {
        if (width == result[1]) {
            result[0] = Math.min(result[0], level);

        } else if (width > result[1]) {
            result[0] = level;
            result[1] = width;
        }
    }
}