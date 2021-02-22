import java.util.*;
import java.io.*;

public class P1102_발전소_Main {
	
	static int N;
	static int[][] cost;
	static int P;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][1<<16];
		cost = new int[N][N];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		char[] chars = br.readLine().toCharArray();
		P = Integer.parseInt(br.readLine());
		
		int ySet = 0;
		int yCnt = 0;
		for(int i=0; i<chars.length; i++) {
			if(chars[i] == 'Y') {
				ySet |= (1<<i);
				yCnt++;
			}
		}
		
		int ans = minCost(yCnt, ySet);
		
		System.out.println(ans == 1000000000 ? -1:ans);
	}
	
	static int minCost(int yCnt, int ySet) {
		// 목표 개수에 도달하면 그만
		if (yCnt >= P) {
			return 0;
		}
		
		// 이미 했으면 리턴
		if (dp[yCnt][ySet] >= 0) {
			return dp[yCnt][ySet];
		}
		
		// 큰 수로 초기화
		dp[yCnt][ySet] = 1000000000;
		
		for(int i=0; i<N; i++) {
			// i 켜져있음
			if ((ySet & (1<<i)) == (1 << i)) {
				for(int j=0; j<N; j++) {
					//j도 켜져있으면 스킵
					if (i==j || (ySet & (1 << j)) == (1<<j)) {
						continue;
					}
					//켜져 있지 않으면 발전소 찾아  계산
					dp[yCnt][ySet] = Math.min(dp[yCnt][ySet], minCost(yCnt+1, ySet | (1<<j)) + cost[i][j]);
				}
			}
		}
		
		return dp[yCnt][ySet];
	}

}
