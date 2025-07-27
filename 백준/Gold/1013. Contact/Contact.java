import java.io.*;

public class Main {
    static final String REGEX_STRING = "(100+1+|01)+";
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();

            sb.append(str.matches(REGEX_STRING) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}