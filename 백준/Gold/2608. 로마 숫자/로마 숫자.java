import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();
    static String romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String b = br.readLine();

        mapInit();
        int sum = romanToInt(a) + romanToInt(b);

        sb.append(sum).append("\n");
        for (int i = 0; i < values.length; i++) {
            while (sum >= values[i]) {
                sb.append(romans[i]);
                sum -= values[i];
            }
        }

        System.out.println(sb);

        br.close();
    }

    static void mapInit() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    static int romanToInt(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int cur = map.get(str.charAt(i));
            if (i + 1 < str.length()) {
                int next = map.get(str.charAt(i + 1));
                if (cur < next) {
                    sum -= cur;
                    continue;
                }
            }
            sum += cur;
        }
        return sum;
    }
}
