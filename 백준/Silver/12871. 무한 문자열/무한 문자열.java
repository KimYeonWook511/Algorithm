import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int sLen = s.length();
        int tLen = t.length();
        int val = (sLen * tLen) / func(Math.max(sLen, tLen), Math.min(sLen, tLen));

        StringBuilder sb1 = new StringBuilder();
        for (int i = val / sLen - 1; i >= 0; i--) {
            sb1.append(s);
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = val / tLen - 1; i >= 0; i--) {
            sb2.append(t);
        }

        System.out.println(sb1.toString().equals(sb2.toString()) ? "1" : "0");

        br.close();
    }

    static int func(int a, int b) {
        if (b == 0) return a;

        return func(b, a % b);
    }
}