import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        int idx = 0;
        int cnt[] = new int[20001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (++cnt[10000 + num] > 1) {
                arr[i] = Integer.MAX_VALUE;

            } else {
                arr[i] = num;
                idx++;
            }
        }

        Arrays.sort(arr);
        
        long result = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i] > 0) break; // 양수는 경우 없음

            // 0일때는 3개 처리 후 종료
            if (arr[i] == 0) {
                if (cnt[10000] >= 3) result += combZero(cnt[10000]);
                break;
            }

            int left = i + 1;
            int right = idx - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    result += cnt[10000 + arr[i]] * cnt[10000 + arr[left]] * cnt[10000 + arr[right]];
                    left++;
                    right--;
                    continue;
                }

                if (sum < 0) left++;
                else right--;
            }

            // i가 2개인 경우
            if (cnt[10000 + arr[i]] >= 2 && arr[i] >= -5000) result += comb(cnt[10000 + arr[i]]) * cnt[10000 - (arr[i] << 1)];

            // 상대방이 2개인 경우
            if (arr[i] % 2 == 0 && cnt[10000 - (arr[i] >> 1)] >= 2) result += cnt[10000 + arr[i]] * comb(cnt[10000 - (arr[i] >> 1)]);
        }

        System.out.println(result);

        br.close();
    }

    static long comb(int n) {
        return (n * (n - 1)) >> 1;
    }

    static long combZero(long n) {
        return n * (n - 1) * (n - 2) / 6;
    }
}