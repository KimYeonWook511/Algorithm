import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][4];

        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());

            arr[run][0] = Integer.parseInt(st.nextToken());
            arr[run][1] = Integer.parseInt(st.nextToken());
            arr[run][2] = Integer.parseInt(st.nextToken());
            arr[run][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i1 = o1[1] * o1[2] * o1[3] - o2[1] * o2[2] * o2[3];
                int i2 = (o1[1] + o1[2] + o1[3]) - (o2[1] + o2[2] + o2[3]);

                if (i1 != 0) return i1;
                else if (i2 != 0) return i2;
                else return o1[0] - o2[0];
            }
        });

        sb.append(arr[0][0]).append(" ").append(arr[1][0]).append(" ").append(arr[2][0]);
        System.out.println(sb.toString());

        br.close();
    }
}