import java.io.*;

public class P5582_공통부분문자열_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		int[][] LCS = new int[A.length+1][B.length+1];
		
		int answer = Integer.MIN_VALUE;
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					LCS[i][j] = LCS[i-1][j-1]+1;
				}
				answer = Math.max(answer, LCS[i][j]);
			}
		}
		System.out.println(answer);
	}

}
