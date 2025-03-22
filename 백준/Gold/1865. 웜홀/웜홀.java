import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int S, E, T;

        Edge (int S, int E, int T) {
            this.S = S;
            this.E = E;
            this.T = T;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            Edge[] edgeArr = new Edge[M + W];
            int minT[] = new int[N + 1];
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edgeArr[i] = new Edge(S, E, T);
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edgeArr[M + i] = new Edge(S, E, -T);
            }

            for (int k = 1; k < N; k++) {
                for (int i = 0; i < M; i++) {
                    Edge cur = edgeArr[i];

                    minT[cur.E] = Math.min(minT[cur.E], minT[cur.S] + cur.T);
                    minT[cur.S] = Math.min(minT[cur.S], minT[cur.E] + cur.T);
                }

                for (int i = 0; i < W; i++) {
                    Edge cur = edgeArr[M + i];

                    minT[cur.E] = Math.min(minT[cur.E], minT[cur.S] + cur.T);
                }
            }

            boolean flag = false;
            for (int i = 0; i < M; i++) {
                Edge cur = edgeArr[i];

                if (minT[cur.E] > minT[cur.S] + cur.T) {
                    flag = true;
                    break;
                }

                if (minT[cur.S] > minT[cur.E] + cur.T) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                for (int i = 0; i < W; i++) {
                    Edge cur = edgeArr[M + i];
    
                    if (minT[cur.E] > minT[cur.S] + cur.T) {
                        flag = true;
                        break;
                    }
                }
            }

            sb.append(flag ? "YES\n" : "NO\n");
        }

        System.out.println(sb);

        br.close();
    }
}