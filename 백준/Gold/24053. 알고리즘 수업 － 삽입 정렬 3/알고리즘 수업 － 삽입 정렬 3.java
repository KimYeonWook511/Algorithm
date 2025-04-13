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

            if (arr[i] == target[i]) cnt++; // 같은 것 개수
        }

        insertionSort();

        System.out.println(cnt == N ? 1 : 0);

        br.close();
    }

    static void insertionSort() {
        for (int i = 1; i < N; i++) {
            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {
                if (arr[j + 1] == target[j + 1]) cnt--;
                arr[j + 1] = arr[j];
                if (arr[j + 1] == target[j + 1]) cnt++;

                if (cnt == N) return;

                j--;
            }

            if (arr[j + 1] == target[j + 1]) cnt--;
            arr[j + 1] = key;
            if (arr[j + 1] == target[j + 1]) cnt++;

            if (cnt == N) return;
        }
    }
}