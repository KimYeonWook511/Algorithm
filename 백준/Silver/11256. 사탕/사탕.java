import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int run = 0; run < t; run++) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                arr[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                j -= arr[n - 1 - i];
                
                if (j <= 0) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}