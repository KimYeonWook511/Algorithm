import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = true;
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (!arr[s][m]) continue;

                for (int e = 0; e < N; e++) {
                    arr[s][e] |= arr[m][e];
                }
            }
        }

        int middleValue = (N + 1) / 2;
        int result = 0;
        for (int s = 0; s < N; s++) {
            int underCount = 0;
            int overCount = 0;
            for (int e = 0; e < N; e++) {
                if (arr[s][e]) overCount++;
                else if (arr[e][s]) underCount++;
            }

            if (underCount >= middleValue || overCount >= middleValue) result++;
        }

        System.out.println(result);

        br.close();
    }
}