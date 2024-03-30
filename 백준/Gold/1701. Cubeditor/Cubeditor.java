import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int strLen = str.length();
        int pi[] = new int[strLen];

        int max = 0;
        
        for (int start = 0; start < strLen; start++) {
            pi[start] = start;
            int left = start;

            for (int right = start + 1; right < strLen; right++) {
                pi[right] = start;

                while (left > start && str.charAt(left) != str.charAt(right)) {
                    left = pi[left - 1];
                }
    
                if (str.charAt(left) == str.charAt(right)) {
                    pi[right] = ++left;
                    max = Math.max(max, left - start);
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}