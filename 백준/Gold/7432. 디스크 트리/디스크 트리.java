import java.io.*;
import java.util.*;

public class Main {
    static class Directory {
        Map<String, Directory> childs;

        Directory () {
            this.childs = new TreeMap<>();
        }

        void insert(String dir) {
            this.childs.putIfAbsent(dir, new Directory());
        }

        Directory getChild(String dir) {
            return this.childs.get(dir);
        }

        static void printTree(int depth, Directory cur) {
            StringBuilder blankSb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                blankSb.append(" ");
            }

            String blank = blankSb.toString();

            for (Map.Entry<String, Directory> set : cur.childs.entrySet()) {
                sb.append(blank).append(set.getKey()).append("\n");

                printTree(depth + 1, set.getValue());
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Directory root = new Directory();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "\\");

            Directory cur = root;
            while (st.hasMoreTokens()) {
                String dir = st.nextToken();

                cur.insert(dir);
                cur = cur.getChild(dir);
            }
        }

        Directory.printTree(0, root);
        System.out.println(sb);

        br.close();
    }
}