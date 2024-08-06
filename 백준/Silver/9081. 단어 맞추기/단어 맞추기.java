import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char arr[] = br.readLine().toCharArray();
            int len = arr.length;

            arr = np(arr, len);

            for (int i = 0; i < len; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static char[] np(char input[], int len) {
        int left = len - 1;
        while (left > 0 && input[left - 1] >= input[left]) {
            left--;
        }
        
        if (left == 0) return input;
        
        int right = len - 1;
        while (input[left - 1] >= input[right]) {
            right--;
        }

        char temp = input[left - 1];
        input[left - 1] = input[right];
        input[right] = temp;

        right = len - 1;
        while (left < right) {
            temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }

        return input;
    }
}