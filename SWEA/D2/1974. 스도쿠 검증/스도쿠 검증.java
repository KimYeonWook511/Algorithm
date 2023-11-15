import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int arr[][] = new int[9][9];
            boolean pass = true;

            // 가로 확인 하면서 값 채우기
            for (int r = 0; r < 9; r++) {
                st = new StringTokenizer(br.readLine());

                boolean chk[] = new boolean[10];

                for (int c = 0; c < 9; c++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[r][c] = num;

                    if (chk[num]) {
                        pass = false;
                        // r = 10; 하면 br.readLine()이 남음
                        break;
                    }

                    chk[num] = true;
                }
            }

            if (pass) {
                // 세로 확인
                for (int c = 0; c < 9; c++) {
                    boolean chk[] = new boolean[10];
    
                    for (int r = 0; r < 9; r++) {
                        int num = arr[r][c];
    
                        if (chk[num]) {
                            pass = false;
                            c = 10;
                            break;
                        }
    
                        chk[num] = true;
                    }
                }
            }

            if (pass) {
                for (int rs = 0; rs < 3; rs++) {
                    for (int cs = 0; cs < 3; cs++) {
                        boolean chk[] = new boolean[10];
    
                        for (int r = 3 * rs; r < 3 * (rs + 1); r++) {
                            for (int c = 3 * cs; c < 3 * (cs + 1); c++) {
                                int num = arr[r][c];
    
                                if (chk[num]) {
                                    pass = false;
                                    r = 1000;
                                    rs = 10;
                                    cs = 10;
                                    break;
                                }

                                chk[num] = true;
                            }
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(pass ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}