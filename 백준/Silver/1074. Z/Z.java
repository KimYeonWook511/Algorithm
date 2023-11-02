import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken()); // N
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[][] = {{0, 1}, {2, 3}};
        int p = -1;

        for (int i = Math.max(r, c); i > 0; i /= 2) {
            p++;
        }

        int point = (int)Math.pow(2, p); // 기준
        int plus = (int)Math.pow(4, p); // 증가량

        while (r > 1 || c > 1) {
            if (r >= point) {
                arr[0][0] += plus * 2;
                arr[0][1] += plus * 2;
                arr[1][0] += plus * 2;
                arr[1][1] += plus * 2;
                r %= point;
            }

            if (c >= point){
                arr[0][0] += plus;
                arr[0][1] += plus;
                arr[1][0] += plus;
                arr[1][1] += plus;
                c %= point;
            }

            point /= 2;
            plus /= 4;
        }
        
        System.out.println(arr[r][c]);

        br.close();
    }
}