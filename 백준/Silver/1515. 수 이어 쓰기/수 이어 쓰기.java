import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int numberLen = number.length();
        int idx = 0;
        int len = 0;
        String val = "";

        for (int i = 1; i <= 30000; i++) {
            val = Integer.toString(i);
            len = val.length();

            for (int j = 0; j < len; j++) {
                if (number.charAt(idx) == val.charAt(j)) idx++;

                if (idx == numberLen) {
                    i = 30000;
                    break;
                }
            }
        }
        
        System.out.println(val);

        br.close();
    }
}