import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (str.charAt(i) != 'E' || str.charAt(i + 1) != 'W') continue;

            result++;
        }

        System.out.println(result);

        br.close();
    }
}