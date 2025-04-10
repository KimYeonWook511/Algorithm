import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int arr[], cnt;
    static boolean isEnd;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);

        if (!isEnd) System.out.println(-1);

        br.close();
    }

    static void quickSort(int left, int right) {
        if (isEnd) return;
        if (left >= right) return;

        int pivotIdx = partition(left, right);

        quickSort(left, pivotIdx - 1);
        quickSort(pivotIdx + 1, right);
    }

    static int partition(int left, int right) {
        int pivot = arr[right]; // 맨 우측을 피벗으로 선택
        int i = left - 1;

        for (int k = left; k < right; k++) {
            // if (arr[k] >= pivot) continue; // 아래와의 차이는?
            if (arr[k] > pivot) continue;

            // swap 하기
            i++;
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            if (chk()) {
                System.out.println(arr[i] + " " + arr[k]);
                return 0;
            }
        }

        if (i + 1 != right) {
            // 피벗을 중앙으로 이동
            int temp = arr[i + 1];
            arr[i + 1] = arr[right];
            arr[right] = temp;
    
            if (chk()) System.out.println(arr[i + 1] + " " + arr[right]);
        }

        return i + 1;
    }

    static boolean chk() {
        if (++cnt == K) isEnd = true;

        return isEnd;
    }
}