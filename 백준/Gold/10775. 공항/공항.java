import java.io.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int result = 0;
        int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            int num = Integer.parseInt(br.readLine());

            int findParent = find(num);

            if (findParent == 0) break;

            result++;
            union(findParent, findParent - 1);
            union(num, findParent - 1);
        }

        System.out.println(result);

        br.close();
    }

    static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}