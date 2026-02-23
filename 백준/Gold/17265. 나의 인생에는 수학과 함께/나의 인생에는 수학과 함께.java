import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char arr[][] = new char[N + 1][N + 1];
        int maxDP[][] = new int[N + 1][N + 1];
        int minDP[][] = new int[N + 1][N + 1];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = st.nextToken().charAt(0);
                maxDP[r][c] = Integer.MIN_VALUE;
                minDP[r][c] = Integer.MAX_VALUE;
            }
        }

        maxDP[0][0] = minDP[0][0] = (arr[0][0] - '0');
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c] == '*') {
                    maxDP[r + 1][c] = maxDP[r][c] * (arr[r + 1][c] - '0');
                    maxDP[r][c + 1] = Math.max(maxDP[r][c + 1], maxDP[r][c] * (arr[r][c + 1] - '0'));
                    minDP[r + 1][c] = minDP[r][c] * (arr[r + 1][c] - '0');
                    minDP[r][c + 1] = Math.min(minDP[r][c + 1], minDP[r][c] * (arr[r][c + 1] - '0'));
                } else if (arr[r][c] == '+') {
                    maxDP[r + 1][c] = maxDP[r][c] + (arr[r + 1][c] - '0');
                    maxDP[r][c + 1] = Math.max(maxDP[r][c + 1], maxDP[r][c] + (arr[r][c + 1] - '0'));
                    minDP[r + 1][c] = minDP[r][c] + (arr[r + 1][c] - '0');
                    minDP[r][c + 1] = Math.min(minDP[r][c + 1], minDP[r][c] + (arr[r][c + 1] - '0'));
                } else if (arr[r][c] == '-') {
                    maxDP[r + 1][c] = maxDP[r][c] - (arr[r + 1][c] - '0');
                    maxDP[r][c + 1] = Math.max(maxDP[r][c + 1], maxDP[r][c] - (arr[r][c + 1] - '0'));
                    minDP[r + 1][c] = minDP[r][c] - (arr[r + 1][c] - '0');
                    minDP[r][c + 1] = Math.min(minDP[r][c + 1], minDP[r][c] - (arr[r][c + 1] - '0'));
                } else {
                    maxDP[r + 1][c] = maxDP[r][c];
                    maxDP[r][c + 1] = Math.max(maxDP[r][c + 1], maxDP[r][c]);
                    minDP[r + 1][c] = minDP[r][c];
                    minDP[r][c + 1] = Math.min(minDP[r][c + 1], minDP[r][c]);
                }
            }
        }

        System.out.println(maxDP[N - 1][N - 1] + " " + minDP[N - 1][N - 1]);

        br.close(); 
    }
}