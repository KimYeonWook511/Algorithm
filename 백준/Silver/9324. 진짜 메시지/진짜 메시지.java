import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int len = input.length();
            int arr[] = new int[26];
            boolean flag = true;

            for (int i = 0; i < len; i++) {
                char ch = input.charAt(i);
                int val = ch - 'A';

                if (++arr[val] != 3) continue;

                if (i == len - 1 || ch != input.charAt(i + 1)) {
                    flag = false;
                    break;
                }

                arr[val] = 0;
                i++;
            }

            sb.append(flag ? "OK\n" : "FAKE\n");
        }
		
		System.out.println(sb);

        br.close();
    }
}