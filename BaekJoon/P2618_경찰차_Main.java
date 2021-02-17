import java.io.*;
import java.util.*;

// 시간초과

public class P2618_경찰차_Main {
	
	static int N;
	static int W;
	static point[] pos;
	static int[][] dp;
	static int[][] choose;
	
	// 좌표 a와 b의 최단 거리
	static int dist(point a, point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	// 경찰차 위치가 각각 pos[x], pos[y]일 때, 현재 상태부터 가능한 최소 거리의 합
	static int solve(int x, int y) {
		int here = Math.max(x, y) + 1;
		if (here == W+2) return 0;
		
		int ret;
		ret = dp[x][y];
		dp[x][y] = ret;
		if(ret != -1) {
			return ret;
		}
		
		// x가 이번 사건 해결
		ret = solve(here, y) + dist(pos[x], pos[here]);
		
		// y가 이번 사건 해결
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
