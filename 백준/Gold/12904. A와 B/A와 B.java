import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        int startIdx = 0;
        int endIdx = t.length() - 1;

        for (int i = t.length() - s.length(); i > 0; i--) {
            char c = t.charAt(endIdx);

            if (c != 'A' && c != 'B') break;

            if (startIdx < endIdx) endIdx--;
            else endIdx++;

            if (c == 'B') {
                int temp = endIdx;
                endIdx = startIdx;
                startIdx = temp;
            }
        }
        
        if (startIdx > endIdx) {
            int temp = endIdx;
            endIdx = startIdx;
            startIdx = temp;
            
            t = new StringBuilder(t.substring(startIdx, endIdx + 1)).reverse().toString();

        } else {
            t = t.substring(startIdx, endIdx + 1);
        }

        System.out.println(s.equals(t) ? 1 : 0);

        br.close();
    }
}