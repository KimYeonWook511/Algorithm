import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        int arr[][] = new int[2][26];
        for (int i = 0; i < len; i++) {
            int alphabet = input.charAt(i) - 'A';

            arr[arr[0][alphabet] == 0 ? 0 : 1][alphabet] = i + 1;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                if (arr[0][i] >= arr[0][k]) continue;
                if (arr[0][k] >= arr[1][i]) continue;
                if (arr[1][i] >= arr[1][k]) continue;

                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}