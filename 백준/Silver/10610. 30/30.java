import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        int arr[] = new int[10];
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            arr[c - '0']++;
            sum += c - '0';
        }

        if (sum % 3 == 0 && arr[0] > 0) {
            for (int i = 9; i >= 0; i--) {
                while (arr[i] > 0) {
                    sb.append(i);
                    arr[i]--;
                }
            }

        } else {
            sb.append("-1");
        }

        System.out.println(sb.toString());

        br.close();
    }
}