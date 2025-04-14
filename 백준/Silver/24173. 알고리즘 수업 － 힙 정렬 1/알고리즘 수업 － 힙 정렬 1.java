import java.io.*;
import java.util.*;

public class Main {
    static int N, K, arr[], cnt;

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

        heapSort();

        if (cnt < K) System.out.println(-1);

        br.close();
    }

    static void heapSort() {
        // 최소 힙 만들기 (build min heap)
        for (int i = (N >> 1) - 1; i >= 0; i--) {
            heapify(i, N);

            if (cnt == K) return;
        }

        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            if (++cnt == K) {
                System.out.println(temp + " " + arr[0]);
                return;
            }

            heapify(0, i);

            if (cnt == K) return;
        }
    }

    static void heapify(int root, int size) {
        int leftChildIdx = (root << 1) + 1;
        int rightChildIdx = (root << 1) + 2;
        int smallerIdx = root;

        // if (rightChildIdx < size && arr[rightChildIdx] < arr[smallerIdx]) smallerIdx = rightChildIdx;
        // else if (leftChildIdx < size && arr[leftChildIdx] < arr[smallerIdx]) smallerIdx = leftChildIdx;
        // else return;

        if (rightChildIdx < size) {
            if (arr[leftChildIdx] < arr[rightChildIdx]) smallerIdx = leftChildIdx;
            else smallerIdx = rightChildIdx;

        } else if (leftChildIdx < size) {
            smallerIdx = leftChildIdx;

        } else {
            return;
        }

        if (arr[smallerIdx] < arr[root]) {
            int temp = arr[root];
            arr[root] = arr[smallerIdx];
            arr[smallerIdx] = temp;

            if (++cnt == K) {
                System.out.println(arr[root] + " " + temp);
                return;
            }

            heapify(smallerIdx, size);
        }
    }
}