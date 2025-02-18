import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();
        int len = P.length();

        int idx = 0;
        int result = 1;
        for (int i = 0; i < len; i++) {
            if (S.indexOf(P.substring(idx, i + 1)) != -1) continue;
            
            result++;
            idx = i;
        }

        System.out.println(result);

        br.close();
    }
}