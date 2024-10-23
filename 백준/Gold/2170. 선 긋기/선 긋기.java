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
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);

                return Integer.compare(o1[0], o2[0]);
            }
        });

        int sum = 0;
        int pre[] = arr[0];
        for (int i = 1; i < N; i++) {
            if (pre[0] <= arr[i][0] && pre[1] >= arr[i][1]) continue;

            if (pre[1] < arr[i][0]) {
                sum += pre[1] - pre[0];
                pre[0] = arr[i][0];
            } 

            pre[1] = arr[i][1];
        }

        System.out.println(sum + pre[1] - pre[0]);

        br.close();
    }
}