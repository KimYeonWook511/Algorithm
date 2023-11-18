import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t = 1; t <= 10; t++) {
            int D = Integer.parseInt(br.readLine());

            int arr[] = new int[100];
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            Arrays.sort(arr);

            int plus = 0;
            int left = 0;
            for (int i = 1; i < 100; i++) {
                plus += (arr[i] - arr[i - 1]) * i;

                if (plus >= D) {
                    left = i;
                    break;
                }
            }

            int minus = 0;
            int right = 0;
            for (int i = 98; i >= 0; i--) {
                minus += (arr[i + 1] - arr[i]) * (99 - i);

                if (minus >= D) {
                    right = i;
                    break;
                }
            }
            
            while (plus > D) {
                plus -= left;
                arr[left]--;
            }

            while (minus > D) {
                minus -= 99 - right;
                arr[right]++;
            }

            if (left == 0) sb.append("#").append(t).append(" ").append(sum % 100 == 0 ? 0 : 1).append("\n");
            else sb.append("#").append(t).append(" ").append(arr[right] - arr[left]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}