import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char arr[][] = new char[n][m];

        for (int r = 0; r < n; r++) {
            String str = br.readLine();

            for (int c = 0; c < m; c++) {
                arr[r][c] = str.charAt(c);
            }
        }

        int max = Math.max(n, m) - 1;

        while (true) {
            boolean flag = false;

            for (int r = 0; r < n - max; r++) {
                for (int c = 0; c < m - max; c++) {
                    int a = arr[r][c];
                    
                    if (a == arr[r][c + max] && a == arr[r + max][c] && a == arr[r + max][c + max]) {
                        flag = true;
                        break;
                    }
                }

                if (flag) break;
            }

            if (flag) break;
            
            max--;
        }

        max++;

        System.out.println(max * max);

        br.close();
    }
}