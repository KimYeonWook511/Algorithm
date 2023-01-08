import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arrInput = new int[10];
		int cnt = 10;
		
		for (int i = 0; i < arrInput.length; i++) {
			arrInput[i] = Integer.parseInt(br.readLine()) % 42;
		}
		
		for (int i = 0; i < arrInput.length; i++) {
			for (int k = i + 1; k < arrInput.length; k++) {
				if (arrInput[i] == arrInput[k]) {
					cnt--;
					break;
				}
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();
	
		br.close();
		bw.close();
	}
}
