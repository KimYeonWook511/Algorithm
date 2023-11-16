import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        String grade[] = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int arr[][] = new int[N][2]; // total / number

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int total = 0;

                total += Integer.parseInt(st.nextToken()) * 35;
                total += Integer.parseInt(st.nextToken()) * 45;
                total += Integer.parseInt(st.nextToken()) * 20;

                arr[i][0] = total;
                arr[i][1] = i + 1;
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });

            for (int i = 0; i < N; i++) {
                if (arr[i][1] == K) sb.append("#").append(t).append(" ").append(grade[i / (N / 10)]).append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}