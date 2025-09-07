import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i][0] = A;
            arr[i][1] = B;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int dpB[] = new int[N];
        int topIndex = -1;
        int dpLeft[] = new int[N];
        int index = 0;

        for (int i = 0; i < N; i++) {
            int B = arr[i][1];

            int left = 0;
            int right = topIndex;
            while (left <= right) {
                int mid = (left + right) >> 1;

                if (dpB[mid] >= B) right = mid - 1;
                else left = mid + 1;
            }

            dpB[left] = B;
            dpLeft[index++] = left;

            if (left > topIndex) topIndex++;
        }

        sb.append(N - (topIndex + 1)).append("\n");

        for (int i = N - 1; i >= 0; i--) {
            if (dpLeft[i] != topIndex) continue;

            arr[i][0] = 0;

            if (--topIndex < 0) break;
        }
        
        for (int i = 0; i < N; i++) {
            if (arr[i][0] != 0) sb.append(arr[i][0]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}