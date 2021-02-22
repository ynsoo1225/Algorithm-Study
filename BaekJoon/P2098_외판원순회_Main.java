import java.util.*;
import java.io.*;

// ��Ʈ �����ڰ� ���ذ� �� ����
// ���� �ƴµ� �ʹ� ��ƴ٤ФФ�
public class P2098_���ǿ���ȸ_Main {
	
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
		// ��� ���� �湮�� ���
		if(visit == (1<<N)-1) {
			if(W[node][0]==0) return INF;
			return W[node][0];
		}
		
		// �̹� ����� ���
		if(dp[node][visit] != INF) {
			return dp[node][visit];
		}
		
		for(int i=0; i<N; i++) {
			int next = visit | (1<<i);
			//i�� ��忡 ���� ���� ���ų� �湮�� ���
			if(W[node][i]==0 || (visit & (1 << i)) != 0) continue;
			dp[node][visit] = Math.min(dp[node][visit], tsp(i, next)+W[node][i]);
		}
		
		return dp[node][visit];
	}

}
