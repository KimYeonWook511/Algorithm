import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int left, right;
        char text;

        Node (int left, int right, char text) {
            this.left = left;
            this.right = right;
            this.text = text;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Node arr[];

    public static void main(String[] args) throws Exception {
        for (int t = 1; t <= 10; t++) {
        	int N = Integer.parseInt(br.readLine());

            arr = new Node[N + 1];

            for (int run = 0; run < N; run++) {
                st = new StringTokenizer(br.readLine());

                int idx = Integer.parseInt(st.nextToken());
                char text = st.nextToken().charAt(0);
                int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

                arr[idx] = new Node(left, right, text);
            }

            sb.append("#").append(t).append(" ");
            func(1);
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int idx) {
        if (idx == 0) return;

        func(arr[idx].left);
        sb.append(arr[idx].text);
        func(arr[idx].right);
    }
}