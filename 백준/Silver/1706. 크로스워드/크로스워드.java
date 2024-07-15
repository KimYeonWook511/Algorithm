import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char arr[][] = new char[R + 1][C];
        String line = "";

        StringBuilder sb = null;
        int len = 0;
        String result = "zzzzzzzzzzzzzzzzzzzz";

        for (int r = 0; r < R; r++) {
            line = br.readLine();

            sb = new StringBuilder();
            len = 0;

            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c);

                if (arr[r][c] == '#') {
                    if (len > 1 && result.compareTo(sb.toString()) > 0) result = sb.toString();

                    sb = new StringBuilder();
                    len = 0;
                    continue;
                }

                sb.append(arr[r][c]);
                len++;
            }

            if (len > 1 && result.compareTo(sb.toString()) > 0) result = sb.toString();
        }

        for (int c = 0; c < C; c++) {
            sb = new StringBuilder();
            len = 0;

            for (int r = 0; r < R; r++) {
                if (arr[r][c] == '#') {
                    if (len > 1 && result.compareTo(sb.toString()) > 0) result = sb.toString();

                    sb = new StringBuilder();
                    len = 0;
                    continue;
                }

                sb.append(arr[r][c]);
                len++;
            }

            if (len > 1 && result.compareTo(sb.toString()) > 0) result = sb.toString();
        }

        System.out.println(result);

        br.close();
    }
}