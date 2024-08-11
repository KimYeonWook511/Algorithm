import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r = x1; r <= x2; r++) {
                for (int c = y1; c <= y2; c++) {
                    arr[r][c]++;
                }
            }
        }
        
        int result = 0;
        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 101; c++) {
                if (arr[r][c] <= M) continue;

                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}