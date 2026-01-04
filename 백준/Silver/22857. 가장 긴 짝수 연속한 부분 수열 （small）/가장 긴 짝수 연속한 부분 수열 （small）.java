import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int S[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int oddCount = 0;
        int evenCount = 0;
        int answer = 0;
        for (int right = 0; right < N; right++) {
            if (S[right] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            while (oddCount > K) {
                if (S[left] % 2 == 0) {
                    evenCount--;
                } else {
                    oddCount--;
                }
                left++;
            }

            answer = Math.max(answer, evenCount);
        }

        System.out.println(answer);

        br.close();
    }
}
