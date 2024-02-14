import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken()); // N
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[][] = {{0, 1}, {2, 3}};
        int p = -1;

        for (int i = Math.max(r, c); i > 0; i >>= 1) {
            p++;
        }

        int point = 1 << p; // 기준 (int)Math.pow(2, p)
        int plus = 1 << (p << 1); // 증가량 (int)Math.pow(4, p)
        
        while (r > 1 || c > 1) {
            if (r >= point) {
                arr[0][0] += plus << 1;
                arr[0][1] += plus << 1;
                arr[1][0] += plus << 1;
                arr[1][1] += plus << 1;
                r %= point;
            }

            if (c >= point){
                arr[0][0] += plus;
                arr[0][1] += plus;
                arr[1][0] += plus;
                arr[1][1] += plus;
                c %= point;
            }

            point >>= 1;
            plus >>= 2;
        }
        
        System.out.println(arr[r][c]);

        br.close();
    }
}