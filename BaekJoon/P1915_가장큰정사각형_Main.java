import java.io.*;
import java.util.*;

public class P1915_가장큰정사각형_Main {
	static int n;
	static int m;
	static int max;
	static int[][] map;
	static int[][] dp;
	
	static int min3(int a, int b, int c) {
		int x = a<b? a:b;
		return x<c? x:c;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		for (int i=1; i<= n; i++) {
			String str = br.readLine();
			for(int j=1; j<=m; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j]==1) {
					dp[i][j] = min3(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
					ans = Math.max(ans, dp[i][j]);
				}
				//System.out.print(dp[i][j]+" ");
			}
			//System.out.println();
		}
		System.out.println(ans*ans);
	}

}
