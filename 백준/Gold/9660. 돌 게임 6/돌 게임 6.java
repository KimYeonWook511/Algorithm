import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long mod = N % 7;
        if (mod == 0 || mod == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

        br.close();
    }
}