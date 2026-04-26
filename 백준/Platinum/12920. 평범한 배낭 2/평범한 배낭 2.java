import java.io.*;
import java.util.*;

public class Main {
    static class Item {
        int w, v;

        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int binary = 1;
            while (K > 0) {
                int count = Math.min(binary, K);

                items.add(new Item(V * count, C * count));

                binary *= 2;
                K -= count;
            }
        }

        int dp[] = new int[M + 1];
        for (Item item : items) {
            for (int w = M; w >= item.w; w--) {
                dp[w] = Math.max(dp[w], dp[w - item.w] + item.v);
            }
        }

        System.out.println(dp[M]);

        br.close();
    }
}