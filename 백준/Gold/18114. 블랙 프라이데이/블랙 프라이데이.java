import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N - 1;

            if (arr[i] == C) {
                flag = true;
                break;
            }

            while (left < right) {
                if (arr[i] + arr[left] == C) {
                    flag = true;
                    break;
                }

                if (arr[i] + arr[right] == C) {
                    flag = true;
                    break;
                }

                int sum = arr[i] + arr[left] + arr[right];

                if (sum == C) {
                    flag = true;
                    break;
                }

                if (sum > C) right--;
                else left++;
            }

            if (flag) break;
        }

        System.out.println(flag ? "1" : "0");

        br.close();
    }
}
