import java.io.*;
import java.util.*;

public class Main {
    static class Planet {
        int i, x, y, z;

        Planet (int i, int x, int y, int z) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge {
        int a, b, w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Planet planets[] = new Planet[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            planets[i] = new Planet(i, x, y, z);
            parent[i] = i;
        }
        
        Edge edges[] = new Edge[N * 3 - 3];
        addEdge(planets, edges, N);        

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        long result = 0;
        int cnt = 0;
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i].a, edges[i].b)) continue;

            result += edges[i].w;
            if (++cnt == N - 1) break;
        }

        System.out.println(result);

        br.close();
    }

    static void addEdge(Planet planets[], Edge edges[], int N) {
        // x기준
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });

        int startIdx = edges.length / 3 * 0 - 1;
        for (int k = 1; k < N; k++) {
            Planet a = planets[k - 1];
            Planet b = planets[k];

            edges[startIdx + k] = new Edge(a.i, b.i, b.x - a.x);
        }

        // y기준
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });

        startIdx = edges.length / 3 * 1 - 1;
        for (int k = 1; k < N; k++) {
            Planet a = planets[k - 1];
            Planet b = planets[k];

            edges[startIdx + k] = new Edge(a.i, b.i, b.y - a.y);
        }

        // z기준
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.z, o2.z);
            }
        });

        startIdx = edges.length / 3 * 2 - 1;
        for (int k = 1; k < N; k++) {
            Planet a = planets[k - 1];
            Planet b = planets[k];

            edges[startIdx + k] = new Edge(a.i, b.i, b.z - a.z);
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;

        return a == b ? false : true;
    }
}