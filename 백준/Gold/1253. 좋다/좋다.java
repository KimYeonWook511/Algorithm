import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i];

            int left = 0;
            int right = N - 1;

            while (true) {
                if (left == i) left++;
                else if (right == i) right--;

                if (left == right) break;

                if (arr[left] + arr[right] < k) left++;
                else if (arr[left] + arr[right] > k) right--;
                else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}