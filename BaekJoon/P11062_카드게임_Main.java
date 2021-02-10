import java.io.*;
import java.util.*;

public class P11062_카드게임_Main {
	static int N;
	static int[] cards;
	static int [][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			cards = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				cards[j] = Integer.parseInt(st.nextToken());
			}
			dp = new int[2][N][N];
			for(int j=0; j<2; j++) {
				for(int k=0; k<N; k++) {
					Arrays.fill(dp[j][k], -1);
				}
			}
			System.out.println(solve(0,0,N-1));
		}

	}
	
	static int solve(int turn, int start, int end) {
		if(dp[turn][start][end] != -1) {
			return dp[turn][start][end];
		}
		
		if(start==end) {
			if(turn==0) return cards[start];
			else return 0;
		}
		
		dp[turn][start][end] = 0;
		if(turn == 0) {
			dp[turn][start][end] = Math.max(solve(1, start+1, end)+cards[start], solve(1, start, end-1)+cards[end]);
		} else {
			dp[turn][start][end] = Math.min(solve(0, start+1, end), solve(0, start, end-1));
		}
		return dp[turn][start][end];
	}

}
