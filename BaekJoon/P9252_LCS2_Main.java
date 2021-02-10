import java.io.*;

public class P9252_LCS2_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		int[][] LCS = new int[A.length+1][B.length+1];
		
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		System.out.println(LCS[A.length][B.length]);
		
		int x = A.length;
		int y = B.length;
		StringBuffer sb = new StringBuffer();
		while(!(x==0 || y==0)) {
			if(A[x-1]==B[y-1]) {
				sb.append(A[x-1]);
				x--; y--;
			} else if (LCS[x][y] == LCS[x-1][y]) {
				x--;
			} else if (LCS[x][y] == LCS[x][y-1]) {
				y--;
			}
		}
		System.out.println(sb.reverse().toString());
	}

}
