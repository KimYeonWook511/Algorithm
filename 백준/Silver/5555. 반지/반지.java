import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());
        
        String ring;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            ring = br.readLine();
            ring += ring;

            if (ring.contains(input)) cnt++;
        }
        
        System.out.println(cnt);
 
        br.close();
    }
}