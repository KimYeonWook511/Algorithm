import java.io.*;
import java.util.*;

public class Main {
    static int preorder[];
    static int inorder[];
    static int index[];
    static StringBuilder postorder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            preorder = new int[n + 1];
            inorder = new int[n + 1];
            index = new int[n + 1];
            postorder = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
                index[inorder[i]] = i;
            }

            func(1, n, 1, n);

            sb.append(postorder).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return;
        if (inLeft > inRight) return;

        int root = preorder[preLeft];
        int rootIndex = index[root];

        int leftSubtreeSize = (rootIndex - inLeft);
        int rightSubtreeSize = (inRight - rootIndex);

        func(preLeft + 1, (preLeft + 1) + leftSubtreeSize - 1, inLeft, rootIndex - 1);
        func(preRight - rightSubtreeSize + 1, preRight, rootIndex + 1, inRight);
        postorder.append(root).append(" ");
    }
}