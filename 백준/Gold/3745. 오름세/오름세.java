import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String line = "";
        while (true) {
            line = br.readLine();

            if (line == null || line.equals("")) break;
            
            int N = Integer.parseInt(line.trim());
            int arr[] = new int[N];
            int len = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());

                int left = 0;
                int right = len - 1;

                while (left <= right) {
                    int mid = (left + right) >> 1;

                    if (arr[mid] >= num) right = mid - 1;
                    else left = mid + 1;
                }

                arr[left] = num;

                if (left == len) len++;
            }

            sb.append(len).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}