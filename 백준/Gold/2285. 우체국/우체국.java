import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long arr[][] = new long[N][2];
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            cnt += arr[i][1];
        }

        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });

        long val = (cnt + 1) / 2;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][1];
            if (sum >= val) {
                System.out.println(arr[i][0]);
                break;
            }
        }

        br.close();
    }
}