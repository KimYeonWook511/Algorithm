import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[], target[], cnt;
    static int tmp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        target = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == target[i]) cnt++; // 같은 것 개수
        }

        mergeSort(0, N - 1);

        System.out.println(cnt == N ? 1 : 0);

        br.close();
    }

    static void mergeSort(int start, int end) {
        if (start >= end) return;
        if (cnt == N) return;

        int mid = (start + end) >> 1;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, mid, end);
    }

    static void merge(int start, int mid, int end) {
        if (cnt == N) return;

        int i = start; // 왼쪽 배열 탐색 인덱스
        int j = mid + 1; // 오른쪽 배열 탐색 인덱스
        int t = 0; // tmp에 넣는 인덱스

        while (true) {
            if (i > mid) break;
            if (j > end) break;

            if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }

        // 왼쪽 남은 것
        while (true) {
            if (i > mid) break;

            tmp[t++] = arr[i++];
        }

        // 오른쪽 남은 것
        while (true) {
            if (j > end) break;

            tmp[t++] = arr[j++];
        }

        i = start;
        t = 0;
        while (true) {
            if (i > end) break;

            // 같았는데 달라짐: -1 + 0 => -1
            // 같았는데 같음: -1 + +1 => 0
            // 달랐는데 다름: 0 + 0 => 0
            // 달랐는데 같아짐: 0 + +1 => 1
            if (arr[i] == target[i]) cnt--;

            arr[i] = tmp[t];

            if (arr[i] == target[i]) cnt++;

            if (cnt == N) return;

            i++;
            t++;
        }
    }
}