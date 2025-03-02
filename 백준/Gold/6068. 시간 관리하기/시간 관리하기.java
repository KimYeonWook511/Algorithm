import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                int val = Integer.compare(o1[1], o2[1]);

                return val == 0 ? -Integer.compare(o1[0], o2[0]) : -val;
            }
        });

        int result = arr[0][1] - arr[0][0];
        for (int i = 1; i < N; i++) {
            if (arr[i][1] <= result) result = arr[i][1];

            result -= arr[i][0];
        }

        System.out.println(result >= 0 ? result : -1);

        br.close();
    }
}