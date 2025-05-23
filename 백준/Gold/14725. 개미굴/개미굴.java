import java.io.*;
import java.util.*;

public class Main {
    static class Prey {
        Map<String, Prey> child;

        Prey () {
            this.child = new TreeMap<>();
        }

        void insert(String str) {
            this.child.putIfAbsent(str, new Prey());
        }

        Prey get(String str) {
            return this.child.get(str);
        }

        void print(int depth, Prey cur) {
            StringBuilder sbDash = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sbDash.append("--");
            }

            String dash = sbDash.toString();

            for (Map.Entry<String, Prey> set : cur.child.entrySet()) {
                sb.append(dash).append(set.getKey()).append("\n");

                print(depth + 1, set.getValue());
            }
        }
    }
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Prey root = new Prey();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            Prey cur = root;
            for (int k = 0; k < K; k++) {
                String str = st.nextToken();

                cur.insert(str);
                cur = cur.get(str);
            }
        }

        root.print(0, root);
        System.out.println(sb);

        br.close();
    }
}