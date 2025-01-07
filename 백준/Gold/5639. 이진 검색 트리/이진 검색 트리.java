import java.io.*;

public class Main {
    static class Node {
        int num;
        Node left;
        Node right;

        Node (int num) {
            this.num = num;
        }

        void insert(Node child) {
            if (child.num < this.num) {
                if (this.left == null) this.left = child;
                else this.left.insert(child);

            } else {
                if (this.right == null) this.right = child;
                else this.right.insert(child);
            }
        }
    }
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(1_000_001);

        String input = "";
        while (true) {
            input = br.readLine();

            if (input == null || input.equals("")) break;

            root.insert(new Node(Integer.parseInt(input)));
        }

        postOrder(root.left);
        System.out.println(sb);

        br.close();
    }

    static void postOrder(Node cur) {
        if (cur == null) return;

        postOrder(cur.left);
        postOrder(cur.right);
        sb.append(cur.num).append("\n");
    }
}