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

        System.out.println(pp() ? sb : -1);

        br.close();
    }

    static boolean pp() {
        int left = N - 1;

        while (left > 0 && arr[left - 1] <= arr[left]) {
            left--;
        }

        if (left <= 0) return false;

        int right = N - 1;

        while (arr[left - 1] <= arr[right]) {
            right--;
        }

        swap(left - 1, right);

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