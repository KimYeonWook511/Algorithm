import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[30];
		boolean flag = true;
		
		for (int i = 0; i < 28; i++) {
			arr[Integer.parseInt(br.readLine()) - 1] = true;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i]) {
				bw.write(Integer.toString(i + 1));
				
				if (flag) bw.write("\n");
				
				flag = false;
				
			}
		}
		
		bw.flush();
	
		br.close();
		bw.close();
	}
}
