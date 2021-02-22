import java.util.*;
import java.io.*;

public class P7579_¾Û_Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int[] memory;
	static int[] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memory = new int[N];
		cost = new int[N];
		dp = new int[N][10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			int c = cost[i];
			int mem = memory[i];
			
			for(int j=0; j<=10000; j++) {
				if(i==0) {
					if(j>=c) dp[i][j] = mem;
				}else {
					if(j>=c) dp[i][j] = Math.max(dp[i-1][j-c] + mem, dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				}
				
				if(dp[i][j] >= M) ans = Math.min(ans,  j);
			}
		}
		System.out.println(ans);

	}

}
