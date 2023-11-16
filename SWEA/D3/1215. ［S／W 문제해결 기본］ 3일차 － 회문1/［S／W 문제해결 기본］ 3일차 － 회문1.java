import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            char arr[][] = new char[8][8];
            int cnt = 0;

            for (int r = 0; r < 8; r++) {
                String str = br.readLine();

                for (int c = 0; c < 8; c++) {
                    arr[r][c] = str.charAt(c);
                }

                for (int step = 0; step <= 8 - N; step++) {
                    boolean flag = true;

                    for (int c = 0; c <= (N - 1) / 2; c++) {
                        if (arr[r][c + step] != arr[r][N - 1 - c + step]) flag = false;
                    }

                    if (flag) cnt++;
                }    
            }

            for (int c = 0; c < 8; c++) {
                for (int step = 0; step <= 8 - N; step++) {
                    boolean flag = true;

                    for (int r = 0; r <= (N - 1) / 2; r++) {
                        if (arr[r + step][c] != arr[N - 1 - r + step][c]) flag = false;
                    }

                    if (flag) cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}