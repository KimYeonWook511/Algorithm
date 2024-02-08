import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, arr[], result[];
    static String input;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(np() ? sb : -1);

        br.close();
    }

    static boolean np() {
        // 오름차순 정렬인 곳 찾기(꼭대기 찾기)
        int left = N - 1;

        while (left > 0 && arr[left - 1] >= arr[left]) {
            left--;
        }

        if (left == 0) return false;

        // 오름차순 정렬의 기준(꼭대기)의 왼쪽 보다 최소한으로 큰 값 찾기
        int right = N - 1;

        while (arr[left - 1] >= arr[right]) {
            right--;
        }

        swap(left - 1, right);

        // 꼭대기의 인덱스 기준으로 내림차순 정렬하기
        right = N - 1;

        while (left < right) {
            swap(left++, right--);
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        return true;
    }

    static void swap(int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}