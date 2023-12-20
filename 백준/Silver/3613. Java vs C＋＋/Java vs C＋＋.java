import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean lang = str.contains("_") ? true : false;

        if (lang) System.out.println(cppToJava(str) ? sb.toString() : "Error!"); 
        else System.out.println(javaToCpp(str) ? sb.toString() : "Error!");

        br.close();
    }

    static boolean cppToJava(String str) {
        int len = str.length();
        char c = str.charAt(0);

        if (!chk(c)) return false;

        sb.append(c);

        for (int i = 1; i < len; i++) {
            c = str.charAt(i);

            if (c == '_') {
                i++;

                if (i == len) return false;
                
                c = str.charAt(i);

                if (!chk(c)) return false;

                sb.append(Character.toUpperCase(c));

            } else if (chk(c)) {
                sb.append(c);

            } else {
                return false; // 대문자
            }
        }

        return true;
    }

    static boolean chk(char c) {
        if (c >= 'a' && c <= 'z') return true;

        return false;
    }

    static boolean javaToCpp(String str) {
        int len = str.length();
        char c = str.charAt(0);

        if (!chk(c)) return false;

        sb.append(c);

        for (int i = 1; i < len; i++) {
            c = str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                sb.append("_").append(Character.toLowerCase(c));

            } else if (chk(c)) {
                sb.append(c);

            } else {
                return false; // '_'
            }
        }

        return true;
    }
}