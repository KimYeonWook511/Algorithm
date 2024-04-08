import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int cnt[] = new int[1_000_001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            cnt[num]++;
        }

        int result = 1;

        int arrIdx = N - 1;
        int cntIdx = 1_000_000;

        while (arrIdx >= 0 && cntIdx >= 0) {
            if (cnt[cntIdx] == 0) {
                cntIdx--;
                continue;
            }

            if (arr[arrIdx] < cntIdx) {
                // 우측으로
                cnt[cntIdx]--;
                result++;
                continue;
            }

            cnt[cntIdx]--;
            arrIdx--;
        }

        System.out.println(result);

        br.close();
    }
}