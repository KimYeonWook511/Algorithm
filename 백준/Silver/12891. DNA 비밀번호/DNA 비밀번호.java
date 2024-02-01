import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 김연욱 
 * @date 24.02.01
 * @link https://www.acmicpc.net/problem/12891
 * @keyword_solution 부분문자열, 최소 조건, 슬라이딩 윈도우, 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다
 * @input 1 ≤ |P| ≤ |S| ≤ 1,000,000
 * @output   
 * @time_complex O(N) 
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String dna = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[26]; // A C G T 개수
		
		arr['A' - 'A'] = Integer.parseInt(st.nextToken());
		arr['C' - 'A'] = Integer.parseInt(st.nextToken());
		arr['G' - 'A'] = Integer.parseInt(st.nextToken());
		arr['T' - 'A'] = Integer.parseInt(st.nextToken());
		
		int startIdx = 0;
		int endIdx = P - 1; // startIdx~endIdx => P
		int cnt = 0;

		// 첫 P만큼의 문자열
		for (int i = startIdx; i <= endIdx; i++) {
			arr[dna.charAt(i) - 'A']--;
		}
		
		if (arr['A' - 'A'] <= 0 && arr['C' - 'A'] <= 0 && arr['G' - 'A'] <= 0 && arr['T' - 'A'] <= 0) cnt++;
		
		endIdx++;
		
		// 슬라이딩
		while (endIdx < S) {
			arr[dna.charAt(startIdx) - 'A']++; // 사용한 거 돌려놓기
			arr[dna.charAt(endIdx) - 'A']--; // 사용할 거 빼기
			
			if (arr['A' - 'A'] <= 0 && arr['C' - 'A'] <= 0 && arr['G' - 'A'] <= 0 && arr['T' - 'A'] <= 0) cnt++;
			
			startIdx++;
			endIdx++;
		}
		
		System.out.println(cnt);

		br.close();
	}
}