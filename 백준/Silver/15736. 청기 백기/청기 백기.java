import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println((int)Math.sqrt(Integer.parseInt(br.readLine())));

        br.close();
    }
}