import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < str.length() - 1; i++) {
            for (int k = i + 1; k < str.length(); k++) {
                list.add(new StringBuilder(str.substring(k) + str.substring(i, k) + str.substring(0, i)).reverse().toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));

        br.close();
    }
}