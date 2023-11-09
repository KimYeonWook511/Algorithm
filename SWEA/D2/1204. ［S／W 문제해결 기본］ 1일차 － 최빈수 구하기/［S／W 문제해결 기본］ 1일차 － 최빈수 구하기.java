import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            br.readLine(); // t

            int arr[] = new int[101];
            int grade = 0;
            int gradeCnt = 0;

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;

                if (arr[num] > gradeCnt) {
                    grade = num;
                    gradeCnt = arr[num];

                } else if (arr[num] == gradeCnt) {
                    grade = Math.max(grade, num);
                }
            }

            sb.append("#").append(t).append(" ").append(grade).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}