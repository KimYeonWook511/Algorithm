import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputPieces = br.readLine().split(" ");
		int[] chessPieces = {1, 1, 2, 2, 2, 8};
		
		for (int i = 0; i < chessPieces.length; i++) {
			bw.write(Integer.toString(chessPieces[i] - Integer.parseInt(inputPieces[i])));
			
			if (i != 5) bw.write(" ");
		}

		bw.flush();

		br.close();
		bw.close();
	}
}
