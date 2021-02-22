import java.util.*;
import java.io.*;

// 비트 연산자가 이해가 안 간다
// 대충 됐는데 너무 어렵다ㅠㅠㅠ
public class P2098_외판원순회_Main {
	
	static int N;
	static int[][] W;
	private static int INF = 16 * 1_000_000;
	static int dp[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][(1<<N)-1];
		W = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], INF);
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(tsp(0,1) + "\n");
		// System.out.println("? "+ (4 | (1 << 3)));
		
		br.close();
		bw.close();

	}
	
	static int tsp(int node, int visit) {
		// 모든 지점 방문한 경우
		if(visit == (1<<N)-1) {
			if(W[node][0]==0) return INF;
			return W[node][0];
		}
		
		// 이미 계산한 경우
		if(dp[node][visit] != INF) {
			return dp[node][visit];
		}
		
		for(int i=0; i<N; i++) {
			int next = visit | (1<<i);
			//i번 노드에 대해 길이 없거나 방문한 경우
			if(W[node][i]==0 || (visit & (1 << i)) != 0) continue;
			dp[node][visit] = Math.min(dp[node][visit], tsp(i, next)+W[node][i]);
		}
		
		return dp[node][visit];
	}

}
