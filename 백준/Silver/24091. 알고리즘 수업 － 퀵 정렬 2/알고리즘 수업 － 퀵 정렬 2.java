import java.io.*;
import java.util.*;

public class Main {
    static int N, K, arr[];
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);

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

    static void quickSort(int left, int right) {
        if (left >= right) return;
        if (cnt == K) return;

        int pivot = partition(left, right);

        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);
    }

    static int partition(int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int k = left; k < right; k++) {
            if (arr[k] > pivot) continue;

            i++;
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            if (++cnt == K) return 0;
        }

        if (i + 1 != right) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[right];
            arr[right] = temp;
            
            cnt++;
        }

        return i + 1;
    }
}