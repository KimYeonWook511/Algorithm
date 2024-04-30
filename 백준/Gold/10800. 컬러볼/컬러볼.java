import java.io.*;
import java.util.*;

public class Main {
	static class Ball {
		int idx, C, S;
		
		Ball(int idx, int C, int S) {
			this.idx = idx;
			this.C = C;
			this.S = S;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Ball arr[] = new Ball[N + 1];
        arr[0] = new Ball(0, 0, 0);
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(arr, new Comparator<Ball>() {
        	@Override
        	public int compare(Ball o1, Ball o2) {
        		return Integer.compare(o1.S, o2.S);
        	}
		});
        
        int sum = 0;
        int tempSum = 0;
        int colorSum[] = new int[N + 1];
        int colorTemp[][] = new int[N + 1][2];
        int tempSize = 0;
        int result[] = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	if (arr[i].S == tempSize) {
        		if (colorTemp[arr[i].C][0] != tempSize) {
        			colorSum[arr[i].C] += colorTemp[arr[i].C][1];
        			colorTemp[arr[i].C][1] = 0;
        		}
        		
        	} else {
        		sum += tempSum;
        		tempSum = 0;
        		
    			colorSum[arr[i].C] += colorTemp[arr[i].C][1];
        		colorTemp[arr[i].C][1] = 0;
        		
        		tempSize = arr[i].S;
        	}
        	
        	result[arr[i].idx] = sum - colorSum[arr[i].C];
        	
        	tempSum += arr[i].S;
        	colorTemp[arr[i].C][0] = arr[i].S;
        	colorTemp[arr[i].C][1] += arr[i].S;
        }
        
        for (int i = 1; i <= N; i++) {
        	sb.append(result[i]).append("\n");
        }
        
        System.out.println(sb);

        br.close();
    }
}