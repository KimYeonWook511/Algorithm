import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'M') {
                cnt++;
            } else {
                max.append("5");
                for (int k = 0; k < cnt; k++) {
                    max.append("0");
                }

                if (cnt > 0) {
                    min.append("1");
                    for (int k = 0; k < cnt - 1; k++) {
                        min.append("0");
                    }
                }
                min.append("5");

                cnt = 0;
            }
        }

        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                max.append("1");
            }

            min.append("1");
            for (int i = 0; i < cnt - 1; i++) {
                min.append("0");
            }
        }

        System.out.println(max + "\n" + min);

        br.close();
    }
}