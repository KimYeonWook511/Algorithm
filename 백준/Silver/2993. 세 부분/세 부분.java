import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();
        
        String result = "z";
        for (int i = 1; i < len - 1; i++) {
            for (int k = i + 1; k < len; k++) {
                String temp = new StringBuilder(input.substring(0, i)).reverse().toString()
                 + new StringBuilder(input.substring(i, k)).reverse() 
                 + new StringBuilder(input.substring(k)).reverse();

                if (result.compareTo(temp) > 0) result = temp;
            }
        }

        System.out.println(result);

        br.close();
    }
}