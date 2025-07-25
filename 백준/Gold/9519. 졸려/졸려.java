import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        list.add(str);
        set.add(str);

        for (int i = 0; i < X; i++) {
            StringBuilder sb = new StringBuilder();

            for (int k = 0; k < str.length(); k += 2) {
                sb.append(str.charAt(k));
            }

            for (int k = str.length() - (str.length() % 2 == 0 ? 1 : 2); k >= 0; k -= 2) {
                sb.append(str.charAt(k));
            }

            str = sb.toString();

            if (!set.add(str)) break;
            list.add(str);
        }
        
        System.out.println(list.get(X % list.size()));

        br.close();
    }
}