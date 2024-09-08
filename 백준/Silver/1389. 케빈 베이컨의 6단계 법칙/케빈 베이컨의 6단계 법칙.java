import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A][B] = arr[B][A] = 1;
        }

        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                if (arr[s][m] == 0) continue;

                for (int e = 1; e <= N; e++) {
                    if (arr[m][e] == 0) continue;
                    if (arr[s][e] != 0 && arr[s][e] <= arr[s][m] + arr[m][e]) continue;
                    
                    arr[s][e] = arr[s][m] + arr[m][e];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int s = 1; s <= N; s++) {
            int sum = 0;

            for (int e = 1; e <= N; e++) {
                sum += arr[s][e];
            }

            if (sum < min) {
                min = sum;
                result = s;
            }
        }

        System.out.println(result);

        br.close();
    }
}