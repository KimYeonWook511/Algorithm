import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String number = br.readLine();
		int arr[] = new int[10];
		
		for (int i = 0; i < number.length(); i++) {
			arr[number.charAt(i) - 48]++;
		}
		
		for (int i = 9; i >= 0; i--) {
			for (int run = 0; run < arr[i]; run++) {
				bw.write(Integer.toString(i));
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
