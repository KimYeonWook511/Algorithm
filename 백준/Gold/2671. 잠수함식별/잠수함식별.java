import java.io.*;

public class Main {
    static final String REGEX_STRING = "(100+1+|01)+";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(br.readLine().matches(REGEX_STRING) ? "SUBMARINE" : "NOISE");

        br.close();
    }
}