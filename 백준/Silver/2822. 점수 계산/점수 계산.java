import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		int arr[] = new int[8];
		int arrSort[] = new int[8];
		int sum = 0;
		
		for (int i = 0; i < 8; i++) {
			int score = Integer.parseInt(br.readLine());
			arr[i] = score;
			arrSort[i] = score;
		}
		
		Arrays.sort(arrSort);
		
		for (int i = 0; i < 8; i++) {
			if (arr[i] > arrSort[2]) {
				sum += arr[i];
				sb.append(i + 1 + " ");
			}
		}
		
		bw.write(sum + "\n" + sb.toString());
		
		br.close();
		bw.close();
	}
}