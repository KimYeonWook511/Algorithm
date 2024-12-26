import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> tree[];
    static int del, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num == -1) {
                root = i;
                continue;
            }

            tree[num].add(i);
        }

        del = Integer.parseInt(br.readLine());
        
        if (root != del) func(root);

        System.out.println(result);

        br.close();
    }

    static void func(int i) {
        boolean flag = false;
        for (int next : tree[i]) {
            if (next == del) continue;

            flag = true;
            func(next);
        }

        if (!flag) result++;
    }
}