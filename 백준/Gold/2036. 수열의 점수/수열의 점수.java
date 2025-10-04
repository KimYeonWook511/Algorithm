import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        int plusCount = 0;
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (arr[i] > 1) plusCount++;
            else if (arr[i] == 1) oneCount++;
        }

        long plus[] = new long[plusCount];
        long minusAndZero[] = new long[n - oneCount - plusCount];
        int plusIndex = 0;
        int minusAndZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 1) plus[plusIndex++] = arr[i];
            else if (arr[i] <= 0) minusAndZero[minusAndZeroIndex++] = arr[i];
        }

        Arrays.sort(plus);
        Arrays.sort(minusAndZero);

        long result = oneCount;
        for (int i = plus.length - 1; i >= 0; i -= 2) {
            if (i == 0) result += plus[i];
            else result += plus[i] * plus[i - 1];
        }

        for (int i = 0; i < minusAndZero.length; i += 2) {
            if (i == minusAndZero.length - 1) result += minusAndZero[i];
            else result += minusAndZero[i] * minusAndZero[i + 1];
        }

        System.out.println(result);

        br.close();
    }
}