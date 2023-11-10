import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int run = 0; run < T; run++) {
            int N = Integer.parseInt(br.readLine());
            int note1[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);
            
            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int k = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = note1.length - 1;
                boolean flag = false;

                while (left <= right) {
                    int avg = (left + right) / 2;

                    int num = note1[avg];

                    if (num < k) left = avg + 1;
                    else if (num > k) right = avg - 1;
                    else {
                        flag = true; 
                        break;
                    }
                }

                sb.append(flag ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}