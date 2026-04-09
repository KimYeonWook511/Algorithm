import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        for (int aLeft = 0; aLeft < N - 1; aLeft++) {
            for (int aRight = aLeft + 3; aRight < N; aRight++) {
                int aSize = arr[aLeft] + arr[aRight];

                int bLeft = aLeft + 1;
                int bRight = aRight - 1;
                while (bLeft < bRight) {
                    int bSize = arr[bLeft] + arr[bRight];
                    int diff = Math.abs(aSize - bSize);

                    answer = Math.min(answer, diff);

                    if (answer == 0) {
                        aLeft = N;
                        aRight = N;
                        break;
                    }

                    if (bSize < aSize) {
                        bLeft++;
                    } else {
                        bRight--;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}