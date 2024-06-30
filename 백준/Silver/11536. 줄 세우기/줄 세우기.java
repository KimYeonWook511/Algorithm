import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        String pre = br.readLine();
        String temp = "";
        int result = 0;

        for (int i = 1; i < N; i++) {
            temp = br.readLine();
            result += pre.compareTo(temp) > 0 ? 1 : -1;

            pre = temp;
        }

        System.out.println(result == N - 1 ? "DECREASING" : (result == 1 - N ? "INCREASING" : "NEITHER"));

        br.close();
    }
}