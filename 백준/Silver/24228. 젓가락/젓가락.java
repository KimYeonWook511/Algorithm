import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(Long.parseLong(st.nextToken()) + 1 + ((Long.parseLong(st.nextToken()) - 1) << 1));

        br.close();
    }
}