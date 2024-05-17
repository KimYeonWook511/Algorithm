import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int K = Integer.parseInt(br.readLine());

        if (arr[0] * arr[1] < K) {
            System.out.println("0");
            
        } else {
            boolean toggle = false;
            int d[] = {1, 1, -1, -1}; // 0, 1 : + (상, 우) / 2, 3 : - (하, 좌)
            int idx = -1;
            int result[] = new int[2];

            // 사전 작업
            arr[0]--;
            result[0]++;

            while (true) {
                idx = (idx + 1) % 4;
                toggle = !toggle;

                if (toggle) {
                    // R
                    K -= arr[1];
                    result[1] += arr[1] * d[idx];

                    if (K > 0) {
                        arr[1]--;
                        continue;
                    }

                    result[1] += (K * d[idx]);
                    break;

                } else {
                    // C
                    K -= arr[0];
                    result[0] += arr[0] * d[idx];

                    if (K > 0) {
                        arr[0]--;
                        continue;
                    }

                    result[0] += (K * d[idx]);
                    break;
                }
            }
            
            System.out.println(result[0] + " " + result[1]);
        }

        br.close();
    }
}