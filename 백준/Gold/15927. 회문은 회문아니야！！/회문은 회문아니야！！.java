import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
		int len = input.length();

		int result = -1;

        for (int i = (input.length() >> 1) - 1; i >= 0; i--) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                result = len;
                break;
            }

            if (input.charAt(i) != input.charAt(i + 1)) result = len - 1;
        }
		
        System.out.println(result);

        br.close();
    }
}