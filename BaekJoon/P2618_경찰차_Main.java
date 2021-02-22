import java.io.*;
import java.util.*;

// �ð��ʰ�

public class P2618_������_Main {
	
	static int N;
	static int W;
	static point[] pos;
	static int[][] dp;
	static int[][] choose;
	
	// ��ǥ a�� b�� �ִ� �Ÿ�
	static int dist(point a, point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	// ������ ��ġ�� ���� pos[x], pos[y]�� ��, ���� ���º��� ������ �ּ� �Ÿ��� ��
	static int solve(int x, int y) {
		int here = Math.max(x, y) + 1;
		if (here == W+2) return 0;
		
		int ret;
		ret = dp[x][y];
		dp[x][y] = ret;
		if(ret != -1) {
			return ret;
		}
		
		// x�� �̹� ��� �ذ�
		ret = solve(here, y) + dist(pos[x], pos[here]);
		
		// y�� �̹� ��� �ذ�
		int ygo = solve(x, here) + dist(pos[y], pos[here]);
		if(ygo < ret) {
			ret = ygo;
			choose[x][y] = 1;
		}
		
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		
		pos = new point[W+2];
		pos[0] = new point(1,1);
		pos[1] = new point(N,N);
		for(int i=2; i<W+2; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		dp = new int[N+1][N+1];
		choose = new int[N+1][N+1];
		
		for(int j=0; j<N+1; j++) {
			Arrays.fill(dp[j], -1);
		}
		
		int ans = solve(0, 1);
		System.out.println(ans);
		
		for(int x=0, y=1; Math.max(x, y)+1 < W+2; ) {
			System.out.println(choose[x][y]+1);
			if(choose[x][y] == 1) {
				y = Math.max(x, y) + 1;
			}else {
				x = Math.max(x, y) + 1;
			}
		}

	}

}

class point{
	int x;
	int y;
	
	point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
