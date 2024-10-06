import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long val = Integer.parseInt(st.nextToken()) * k + Integer.parseInt(st.nextToken());

        System.out.println((val - (Integer.parseInt(st.nextToken()) * k + Integer.parseInt(st.nextToken()))) == 0 ? "Yes " + val : "No");

        br.close();
    }
}