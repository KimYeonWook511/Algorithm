import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];
        int result[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;

            result[i] = arr[i][0];
        }

        int S = Integer.parseInt(br.readLine());

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                // 배열에 있는 모든 수는 서로 다르기 때문에 val이 0이 나올 수 없음!
                // int val = -Integer.compare(o1[0], o2[0]);
                //
                // return val == 0 ? Integer.compare(o1[1], o2[1]) : val;

                return -Integer.compare(o1[0], o2[0]);
            }
        });

        int sortedIdx = N - 1; // N-1: 이미 다 정렬되고도 S가 남는 경우 고려
        for (int i = 0; i < N; i++) {
            if (S <= 0) {
                sortedIdx = i - 1;
                break;
            }

            // 최대 50
            for (int k = 0; k < N; k++) {
                if (arr[k][1] < i) continue; // 정렬할 필요 없음
                if (arr[k][1] - i > S) continue; // S가 부족함

                // 옮기기
                result[i] = arr[k][0];

                if (arr[k][1] == i) break; // 이후 숫자는 값이 다 작아서 i에 넣으면 숫자가 작아짐

                S -= arr[k][1] - i;

                // 배열 우측으로 한 칸씩 밀림 처리 (+1 처리)
                for (int j = 0; j < N; j++) {
                    if (arr[j][1] >= i && arr[j][1] < arr[k][1]) arr[j][1]++;
                }

                arr[k][1] = i;
                break;
            }
        }

        if (S == 0) {
            for (int i = 0; i < N; i++) {
                if (arr[i][1] > sortedIdx) {
                    result[arr[i][1]] = arr[i][0];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}