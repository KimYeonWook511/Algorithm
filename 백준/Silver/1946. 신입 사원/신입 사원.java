import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int cnt = 1;
            int temp = arr[0][1];

            for (int i = 1; i < N; i++) {
                if (arr[i][1] < temp) {
                    cnt++;
                    temp = arr[i][1];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}