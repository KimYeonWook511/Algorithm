import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        boolean arr[] = new boolean[len];
        for (int i = 0; i < len; i++) {
            arr[i] = input.charAt(i) == 'Y';
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (!arr[i]) continue;

            result++;
            for (int k = i; k < len; k += i + 1) {
                arr[k] = !arr[k];
            }
        }

        System.out.println(result);

        br.close();
    }
}