import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int len = str.length();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == 'X') {
                cnt++;

                if (cnt == 4) {
                    sb.append("AAAA");
                    cnt = 0;
                }

            } else if (cnt == 2) {
                sb.append("BB.");
                cnt = 0;

            } else if (cnt == 0) {
                sb.append(".");

            } else {
                break;
            }
        }
    
        if (cnt == 4) sb.append("AAAA");
        else if (cnt == 2) sb.append("BB");
        else if (cnt % 2 != 0) sb = new StringBuilder().append(-1);

        System.out.println(sb.toString());

        br.close();
    }
}