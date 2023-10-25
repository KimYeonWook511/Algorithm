import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        StringTokenizer st;
        
        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[run][0] = s;
            arr[run][1] = e;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) {
                cnt++;
                end = arr[i][1];
            }
        }

        System.out.println(cnt);

        br.close();
    }
}