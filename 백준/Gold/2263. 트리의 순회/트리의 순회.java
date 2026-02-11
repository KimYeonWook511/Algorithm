import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int inorder[];
    static int postorder[];
    static int index[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        index = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            index[inorder[i]] = i;
        }

        postorder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        func(1, n, 1, n);

        System.out.println(sb);

        br.close();
    }

    static void func(int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight) return;
        if (postorderLeft > postorderRight) return;

        int root = postorder[postorderRight];
        int rootIndex = index[root];

        int leftSubtreeSize = (rootIndex - inorderLeft);
        int rightSubtreeSize = (inorderRight - rootIndex);

        sb.append(root).append(" ");
        func(inorderLeft, rootIndex - 1, postorderLeft, postorderLeft + leftSubtreeSize - 1);
        func(rootIndex + 1, inorderRight, postorderRight - rightSubtreeSize, postorderRight - 1);
    }
}