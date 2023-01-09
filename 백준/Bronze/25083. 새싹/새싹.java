import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("         ,r'\"7\n");
		bw.write("r`-_   ,'  ,/\n");
		bw.write(" \\. \". L_r'\n");
		bw.write("   `~\\/\n");
		bw.write("      |\n");
		bw.write("      |");
		bw.flush();

		bw.close();
	}
}
