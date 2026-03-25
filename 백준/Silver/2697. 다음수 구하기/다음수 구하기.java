import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            char arr[] = br.readLine().toCharArray();

            if (nextPermutation(arr)) {
                sb.append(arr).append('\n');
            } else {
                sb.append("BIGGEST").append('\n');
            }
        }

        System.out.print(sb);

        br.close();
    }

    private static boolean nextPermutation(char arr[]) {
        int n = arr.length;

        // arr[i] < arr[i+1] 인 가장 오른쪽 i 찾기
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // 이미 가장 큰 순열
        if (i < 0) return false;

        // arr[i]보다 큰 수 중 가장 오른쪽 j 찾기
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // swap
        swap(arr, i, j);

        // i+1 ~ 끝 뒤집기
        reverse(arr, i + 1, n - 1);

        return true;
    }

    private static void swap(char arr[], int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char arr[], int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}