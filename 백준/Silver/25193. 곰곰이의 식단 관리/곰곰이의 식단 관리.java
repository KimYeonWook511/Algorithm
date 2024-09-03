import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        int cnt = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) != 'C') continue;
            
            cnt++;
        }

        System.out.println(cnt / (N - cnt + 1) + (cnt % (N - cnt + 1) == 0 ? 0 : 1));

        br.close();
    }
}