import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // N
        int M = Integer.parseInt(st.nextToken());

        boolean result = true;

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            int arr[] = new int[k];
            arr[0] = Integer.parseInt(st.nextToken());

            for (int j = 1; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

                if (arr[j - 1] < arr[j]) {
                    result = false;
                    break;
                }
            }
        }

        System.out.println(result ? "Yes" : "No");

        br.close();
    }
}