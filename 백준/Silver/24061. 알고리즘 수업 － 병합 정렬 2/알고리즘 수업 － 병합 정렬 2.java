import java.io.*;
import java.util.*;

public class Main {
    static int N, K, arr[];
    static int tmp[], cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        
        if (cnt == K) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);

        br.close();
    }

    static void mergeSort(int start, int end) {
        if (start >= end) return;
        if (cnt == K) return;

        int mid = (start + end) >> 1;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, mid, end);
    }

    static void merge(int start, int mid, int end) {
        if (cnt == K) return;

        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }

        while (i <= mid) {
            // 왼쪽 배열 부분이 남은 경우
            tmp[t++] = arr[i++];
        }

        while (j <= end) {
            // 오른쪽 배열 부분이 남은 경우
            tmp[t++] = arr[j++];
        }

        i = start;
        t = 0;

        while (i <= end) {
            // 결과 저장
            arr[i++] = tmp[t++];
            
            if (++cnt == K) return;
        }
    }
}