import java.io.*;
import java.util.*;

public class Main {
    static class Meat {
        int w, p;

        Meat (int w, int p) {
            this.w = w;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Meat arr[] = new Meat[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i] = new Meat(w, p);
        }

        Arrays.sort(arr, new Comparator<Meat>() {
            @Override
            public int compare(Meat o1, Meat o2) {
                if (o1.p == o2.p) return -Integer.compare(o1.w, o2.w);

                return Integer.compare(o1.p, o2.p);
            }
        });

        int pre = 0;
        int wSum = 0;
        int pSum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            wSum += arr[i].w;

            if (pre == arr[i].p) pSum += arr[i].p;
            else pSum = pre = arr[i].p;

            if (wSum >= M) result = Math.min(result, pSum);
        }

        System.out.println(wSum < M ? -1 : result);

        br.close();
    }
}