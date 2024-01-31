import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int T, N, num, bit;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            
            bit = (1 << 10) - 1;
            num = N;

            while (true) {
            	String str = Integer.toString(num);
            	int len = str.length();
            	
            	for (int i = 0; i < len; i++) {
            		bit &= ~(1 << str.charAt(i) - '0');
            	}
            	
            	if (bit == 0) break;
            	
            	num += N;
            }
            
            sb.append("#").append(t).append(" ").append(num).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}