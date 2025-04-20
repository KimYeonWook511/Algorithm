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
        }

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] != target[i]) break;

            cnt++;
        }

        if (cnt != N) {
            int sortingIdx = N - cnt - 1;
            cnt = 0;

            // int copyArr[] = new int[sortingIdx];
            // for (int i = 0; i < copyArr.length; i++) {
            //     copyArr[i] = arr[i];
            // }
            // Arrays.sort(copyArr);
            // for (int i = 0; i < copyArr.length; i++) {
            //     arr[i] = copyArr[i];
    
            //     if (arr[i] == target[i]) cnt++;
            // }
    
            // for (int i = copyArr.length; i < N; i++) {
            //     if (arr[i] == target[i]) cnt++;
            // }

            Arrays.sort(arr, 0, sortingIdx);

            for (int i = 0; i < N; i++) {
                if (arr[i] == target[i]) cnt++;
            }
    
            insertionSort(sortingIdx);
        }

        System.out.println(cnt == N ? 1 : 0);

        br.close();
    }

    static void insertionSort(int sortingIdx) {
        if (cnt == N) return;

        int key = arr[sortingIdx];
        int idx = sortingIdx - 1;

        while (idx >= 0 && arr[idx] > key) {
            if (arr[idx + 1] == target[idx + 1]) cnt--;
            arr[idx + 1] = arr[idx];
            if (arr[idx + 1] == target[idx + 1]) cnt++;

            idx--;

            if (cnt == N) return;
        }

        if (idx + 1 != sortingIdx) {
            if (arr[idx + 1] == target[idx + 1]) cnt--;
            arr[idx + 1] = key;
            if (arr[idx + 1] == target[idx + 1]) cnt++;

            if (cnt == N) return;
        }
    }
}