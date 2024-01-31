import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
        for (int t = 1; t <= 10; t++) {
            br.readLine(); // t : 테스트케이스 번호

            int arr[] = new int[50];
            int idx[] = new int[50];
            int cnt = 0;
            
            // row = 0
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
            	if (st.nextToken().equals("1")) {
            		arr[cnt] = i;
            		idx[cnt++] = i;
            	}
            }
            
            // row = 1 ~ 98
            String line = "";
            int temp = 0;
            
            for (int r = 1; r < 99; r++) {
            	line = br.readLine();
            	
            	for (int i = 1; i < cnt; i++) { // i=0일 경우엔 idx[cnt-1]=99라면 199이고 line은 0~198까지만 존재
            		if (line.charAt(idx[i] * 2 - 2) == '1') {
            			temp = arr[i - 1];
            			arr[i - 1] = arr[i];
            			arr[i] = temp;
            		}
            	}
            }
            
            // row = 99
            line = br.readLine();
            
            for (int i = 0; i < cnt; i++) {
            	if (line.charAt(idx[i] * 2) == '2') {
            		sb.append("#").append(t).append(" ").append(arr[i]).append("\n");
            		break;
            	}
            }
        }
        
        System.out.println(sb);

        br.close();
    }
}