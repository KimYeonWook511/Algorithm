import java.io.*;
 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int alphabet[] = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		
		String first = br.readLine();
		String second = br.readLine();
		
		int arr[] = new int[first.length() + second.length()];
		int len = arr.length;

        for (int i = 0; i < len - 1; i += 2) {
        	arr[i] = alphabet[first.charAt(i >> 1) - 65];
            arr[i + 1] = alphabet[second.charAt(i >> 1) - 65];
        }
        
        while (len > 2) {
            for (int i = 0; i < len - 1; i++) {
            	arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            
            arr[--len] = 0;
        }
 
        System.out.println(arr[0] + "" + arr[1]);
        
		br.close();
	}
}