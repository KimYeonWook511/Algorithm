import java.io.*;
import java.util.*;

public class Main {
    static int N, K, arr[], cnt;

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

        heapSort();

        if (cnt != K) sb.append(-1);
        else {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }

    static void heapSort() {
        // 최소 힙 만들기
        for (int i = (N >> 1) - 1; i >= 0; i--) {
            // 하나의 서브트리 heapify 
            heapify(i, N);

            if (cnt == K) return;
        }

        // 정렬하기 (최소 힙 -> 내림차순 정렬)
        for (int i = N - 1; i > 0; i--) {
            // 맨 오른쪽으로 옮기기
            swap(0, i);

            if (++cnt == K) return;

            heapify(0, i); // size는 옮긴 인덱스 이후로는 heapify를 진행하지 않아야 함!

            if (cnt == K) return;
        }
    }

    static void heapify(int root, int size) {
        int leftChildIdx = (root << 1) + 1;
        int smallerIdx = root;

        if (leftChildIdx < size && arr[leftChildIdx] < arr[smallerIdx]) smallerIdx = leftChildIdx;
        if (leftChildIdx + 1 < size && arr[leftChildIdx + 1] < arr[smallerIdx]) smallerIdx = leftChildIdx + 1;

        if (smallerIdx != root) {
            // 최상단이 제일 작지 않다면 스왑
            swap(smallerIdx, root);

            if (++cnt == K) return;

            // 맨 아래(size)까지 heapify 진행
            heapify(smallerIdx, size);
        }
    }

    static void swap(int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}