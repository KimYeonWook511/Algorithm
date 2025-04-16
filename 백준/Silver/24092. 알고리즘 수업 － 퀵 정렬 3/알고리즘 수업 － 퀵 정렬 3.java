import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[], target[], cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        target = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == target[i]) cnt++;
        }

        quickSort(0, N - 1);

        System.out.println(cnt == N ? 1 : 0);

        br.close();
    }

    static void quickSort(int start, int end) {
        if (start >= end) return;
        if (cnt == N) return;

        int pivotIndex = partition(start, end);

        quickSort(start, pivotIndex - 1);
        quickSort(pivotIndex + 1, end);
    }

    static int partition(int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int k = start; k < end; k++) {
            if (arr[k] > pivot) continue;

            i++;

            if (arr[i] == target[i]) cnt--;
            if (arr[k] == target[k]) cnt--;

            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            if (arr[i] == target[i]) cnt++;
            if (arr[k] == target[k]) cnt++;

            if (cnt == N) return 0;
        }

        if (i + 1 != end) {
            if (arr[i + 1] == target[i + 1]) cnt--;
            if (arr[end] == target[end]) cnt--;

            int temp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = temp;

            if (arr[i + 1] == target[i + 1]) cnt++;
            if (arr[end] == target[end]) cnt++;

            if (cnt == N) return 0;
        }

        return i + 1;
    }
}