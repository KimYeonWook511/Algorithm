import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, parent[], K, temp, result[], cnt;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for (int run = 0; run < K; run++) {
            parent[Integer.parseInt(st.nextToken())] = 0;
        }

        result = new int[M];

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            // if (K != 0) result[run] = Integer.parseInt(st.nextToken());
            result[run] = Integer.parseInt(st.nextToken()); // 파티의 오는 사람의 수는 1이상 50이하

            for (int run2 = 1; run2 < K; run2++) {
                union(Integer.parseInt(st.nextToken()), result[run]);
            }
        }

        for (int run = 0; run < M; run++) {
            if (findRoot(result[run]) != 0) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    static int findRoot(int x) { // find의 시간복잡도는 트리의 높이에 의해 결정됨
        // x가 root라면 반환
        if (x == parent[x]) return x;

        // x가 자식이라면, 부모 노드로 올라가면서 찾기 (재귀 수행)
        // root로 최신화
        return parent[x] = findRoot(parent[x]);
    }

    static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        // 작은 것을 큰 것에 합쳐야 시간 복잡도 효율성 상승
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}