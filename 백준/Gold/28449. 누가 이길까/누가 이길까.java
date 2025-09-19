import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int HI[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            HI[i] = Integer.parseInt(st.nextToken());
        }

        int ARC[] = new int[M];
        int cntARC[] = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ARC[i] = Integer.parseInt(st.nextToken());
            cntARC[ARC[i]]++;
        }

        // Arrays.sort(HI);
        Arrays.sort(ARC);

        long result[] = new long[3];
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = M - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;

                if (HI[i] >= ARC[mid]) left = mid + 1;
                else right = mid - 1;
            }

            result[0] += (right + 1) - cntARC[HI[i]];
            result[1] += M - (right + 1);
            result[2] += cntARC[HI[i]];
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);

        br.close();
    }
}