import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        String input = "";

        while (true) {
            input = br.readLine();

            if (input.charAt(0) == '0') break;

            int len = input.length();
            boolean flag = input.charAt(0) == '1' && input.charAt(len - 1) == '2';

            if (flag) {
                for (int i = 0; i < len - 1; i++) {
                    char ch = input.charAt(i);

                    if (ch == '2') {
                        flag = false;
                        break;
                    }
    
                    if (ch == '1' || ch == '3') {
                        if (input.charAt(i + 1) == '4' || input.charAt(i + 1) == '5') continue;

                        flag = false;
                        break;
                    }
    
                    if (ch == '4' || ch == '6') {
                        if (input.charAt(i + 1) == '2' || input.charAt(i + 1) == '3') continue;

                        flag = false;
                        break;
                    }

                    if (ch == '5' || ch == '7') {
                        if (input.charAt(i + 1) == '8') continue;

                        flag = false;
                        break;
                    }

                    if (ch == '8') {
                        if (input.charAt(i + 1) == '6' || input.charAt(i + 1) == '7') continue;

                        flag = false;
                        break;
                    }
                }
            }

            sb.append(t++).append(". ").append(flag ? "VALID" : "NOT").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}