import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        int B[] = new int[n];
        int C[] = new int[n];
        int D[] = new int[n];

        int AB[] = new int[n * n];
        int CD[] = new int[n * n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());

            for (int k = 0; k < i; k++) {
                AB[i * i + (k << 1)] = A[i] + B[k];
                AB[i * i + (k << 1) + 1] = A[k] + B[i];
                CD[i * i + (k << 1)] = C[i] + D[k];
                CD[i * i + (k << 1) + 1] = C[k] + D[i];
            }

            AB[(i + 1) * (i + 1) - 1] = A[i] + B[i];
            CD[(i + 1) * (i + 1) - 1] = C[i] + D[i];
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int abIdx = 0;
        int cdIdx = CD.length - 1;
        long cnt = 0;
        while (abIdx < AB.length && cdIdx >= 0) {
            int sum = AB[abIdx] + CD[cdIdx];

            if (sum == 0) {
                long abCnt = 0;
                long cdCnt = 0;

                while (true) {
                    abCnt++;
                    abIdx++;

                    if (abIdx >= AB.length) break;
                    if (AB[abIdx] != AB[abIdx - 1]) break;
                }

                while (true) {
                    cdCnt++;
                    cdIdx--;

                    if (cdIdx < 0) break;
                    if (CD[cdIdx] != CD[cdIdx + 1]) break;
                }

                cnt += abCnt * cdCnt;

                continue;
            }

            if (sum < 0) abIdx++;
            else cdIdx--;
        }

        System.out.println(cnt);

        br.close();
    }
}