import java.util.*;
import java.io.*;

public class P1102_������_Main {
	
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
		// ��ǥ ������ �����ϸ� �׸�
		if (yCnt >= P) {
			return 0;
		}
		
		// �̹� ������ ����
		if (dp[yCnt][ySet] >= 0) {
			return dp[yCnt][ySet];
		}
		
		// ū ���� �ʱ�ȭ
		dp[yCnt][ySet] = 1000000000;
		
		for(int i=0; i<N; i++) {
			// i ��������
			if ((ySet & (1<<i)) == (1 << i)) {
				for(int j=0; j<N; j++) {
					//j�� ���������� ��ŵ
					if (i==j || (ySet & (1 << j)) == (1<<j)) {
						continue;
					}
					//���� ���� ������ ������ ã��  ���
					dp[yCnt][ySet] = Math.min(dp[yCnt][ySet], minCost(yCnt+1, ySet | (1<<j)) + cost[i][j]);
				}
			}
		}
		
		return dp[yCnt][ySet];
	}

}
