import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";

        while ((input = br.readLine()) != null) {
            BigInteger num = BigInteger.ONE;

            for (int i = input.length() - 1; i > 0; i--) {
                num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);
            }
            
            while (num.mod(new BigInteger(input)) != BigInteger.ZERO) {
                num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);
            }

            sb.append(num.toString().length()).append("\n");        
        }

        System.out.println(sb.toString());

        br.close();
    }
}