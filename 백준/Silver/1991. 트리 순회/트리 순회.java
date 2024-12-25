import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char root, left, right;

        Node (char root, char left, char right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    static Node tree[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[root - 'A'] = new Node(root, left, right);
        }
        
        preorder('A');
        sb.append("\n");

        inorder('A');
        sb.append("\n");

        postorder('A');

        System.out.println(sb);

        br.close();
    }

    static void preorder(char root) {
        Node cur = tree[root - 'A'];

        // 전위 M L R
        sb.append(cur.root);
        if (cur.left != '.') preorder(cur.left);
        if (cur.right != '.') preorder(cur.right);
    }

    static void inorder(char root) {
        Node cur = tree[root - 'A'];

        // 중위 L M R
        if (cur.left != '.') inorder(cur.left);
        sb.append(cur.root);
        if (cur.right != '.') inorder(cur.right);
    }

    static void postorder(char root) {
        Node cur = tree[root - 'A'];

        // 후위 L R M
        if (cur.left != '.') postorder(cur.left);
        if (cur.right != '.') postorder(cur.right);
        sb.append(cur.root);
    }
}