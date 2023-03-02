import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int arr[] = new int[n + 1];
      int cnt[] = new int[m];
      long pascal[] = new long[1_000_001]; // 2C2 ~~~ 1,000,000C2 (조합)
      long result = 0;
      
      st = new StringTokenizer(br.readLine());
      
      for (int i = 1; i <= n; i++) {
         arr[i] = (Integer.parseInt(st.nextToken()) + arr[i - 1]) % m;
         cnt[arr[i]]++; // 해당 되는 나머지 카운트 증가
      }
      
      cal(pascal);
      result += cnt[0]; // 첫 번째 수 부터 연속된 부분 구간의 합의 나머지가 0인 경우
      
      for (int i = 0; i < m; i++) {
         if (cnt[i] > 1) result += pascal[cnt[i]]; // 첫 번째 수를 제외한 연속된 부분 구간의 합의 나머지가 0인 경우
      }
      
      bw.write(Long.toString(result));
      bw.flush();

      br.close();
      bw.close();
   }

	static void cal(long pascal[]) {
		// 2C2 ~~~ 1000C2 (조합) 결과 계산하기
		for (int i = 2; i <= 1_000_000; i++) {
			pascal[i] = pascal[i - 1] + i - 1;
		}
	}
}