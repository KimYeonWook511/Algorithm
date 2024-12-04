import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String start = br.readLine();
        String end = br.readLine();
        int len = start.length();

        boolean arr1[] = new boolean[len];
        boolean arr2[] = new boolean[len];
        boolean result[] = new boolean[len];

        for (int i = 0; i < len; i++) {
            arr1[i] = arr2[i] = start.charAt(i) - '0' == 1 ? true : false;
            result[i] = end.charAt(i) - '0' == 1 ? true : false;
        }

        arr2[0] = !arr2[0];
        arr2[1] = !arr2[1];
        int arr1Cnt = 0;
        int arr2Cnt = 1;

        for (int i = 2; i < len; i++) {
            if (arr1[i - 2] != result[i - 2]) {
                arr1[i - 1] = !arr1[i - 1];
                arr1[i] = !arr1[i];

                arr1Cnt++;
            }

            if (arr2[i - 2] != result[i - 2]) {
                arr2[i - 1] = !arr2[i - 1];
                arr2[i] = !arr2[i];

                arr2Cnt++;
            }
        }

        if (arr1[len - 2] != result[len - 2]) {
            arr1[len - 1] = !arr1[len - 1];
            arr1Cnt++;
        }

        if (arr2[len - 2] != result[len - 2]) {
            arr2[len - 1] = !arr2[len - 1];
            arr2Cnt++;
        }

        int answer = Integer.MAX_VALUE;
        if (arr1[len - 1] == result[len - 1]) answer = arr1Cnt;
        if (arr2[len - 1] == result[len - 1]) answer = Math.min(answer, arr2Cnt);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }
}