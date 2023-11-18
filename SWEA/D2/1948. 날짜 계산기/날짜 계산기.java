import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int bm = Integer.parseInt(st.nextToken());
            int bd = Integer.parseInt(st.nextToken());
            int am = Integer.parseInt(st.nextToken());
            int ad = Integer.parseInt(st.nextToken());

            int day = ad - bd + 1;

            while (bm < am) {
                switch (bm) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        day += 31;                        
                        break;
                    case 2:
                        day += 28;
                        break;
                    default:
                        day += 30;
                        break;
                }

                bm++;
            }

            sb.append("#").append(t).append(" ").append(day).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}