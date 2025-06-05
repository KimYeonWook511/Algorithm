import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];

        for (int s = 0; s < N; s++) {
            for (int e = 0; e < N; e++) {
                arr[s][e] = 1_000_000_001;
            }
            
            arr[s][s] = 0;
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;

            if (a < 0) break;

            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = arr[b][a] = 1;
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (s == m) continue;

                for (int e = 0; e < N; e++) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
		int result[] = new int[N];
		for (int s = 0; s < N; s++) {
			int temp = 0;

			for (int e = 0; e < N; e++) {
				temp = Math.max(temp, arr[s][e]);
			}

			result[s] = temp;
			min = Math.min(min, temp);
		}
		
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (result[i] != min) continue;

            sb.append(i + 1).append(" ");
            cnt++;
		}

        System.out.println(min + " " + cnt);
        System.out.println(sb);

        br.close();
    }
}