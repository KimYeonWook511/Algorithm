import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        String first = br.readLine();
        int firstLen = first.length();

        int firstArr[] = new int[26];
        for (int i = 0; i < firstLen; i++) {
            firstArr[first.charAt(i) - 'A']++;
        }

        for (int run = 1; run < N; run++) {
            String str = br.readLine();
            int strLen = str.length();

            int strArr[] = new int[26];
            for (int i = 0; i < strLen; i++) {
                strArr[str.charAt(i) - 'A']++;
            }

            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += Math.abs(firstArr[i] - strArr[i]);
            }

            if (firstLen == strLen) {
                if (sum < 3) result++;

            } else if (sum < 2) {
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}