import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Map<Character, Node> childs;
        int cnt;

        Node () {
            childs = new HashMap<>();
            cnt = 0;
        }

        void insert(String name) {
            Node cur = root;
            boolean prefixFlag = false;
            for (int i = 0; i < name.length(); i++) {
                char ch = name.charAt(i);

                if (!cur.childs.containsKey(ch)) {
                    cur.childs.put(ch, new Node());

                    if (!prefixFlag) {
                        sb.append(name.substring(0, i + 1)).append("\n");
                        prefixFlag = true;
                        // cur.childs.get(ch).cnt++;
                    }
                }

                cur = cur.childs.get(ch);
            }

            cur.cnt++;

            if (!prefixFlag) {
                sb.append(name).append(cur.cnt == 1 ? "" : cur.cnt).append("\n");
            }
        }
    }

    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            root.insert(name);
        }

        System.out.println(sb);

        br.close();
    }
}