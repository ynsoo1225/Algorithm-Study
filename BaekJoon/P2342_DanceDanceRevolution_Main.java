import java.io.*;
import java.util.*;

public class P2342_DanceDanceRevolution_Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][][] dp;
	static ArrayList<Integer> map = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		set();
		solve();
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void set() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(true) {
			int k = Integer.parseInt(st.nextToken());
			if (k==0) break;
			map.add(k);
		}
		dp = new int[map.size()][5][5];
	}
	
	static void solve() throws IOException {
		bw.write(dfs(0,0,0)+"");
	}
	
	static int dfs(int x, int left, int right) {
		if(x==map.size()) {
			return 0;
		}
		if(dp[x][left][right] != 0) {
			return dp[x][left][right];
		}
		
		int goLeft = dfs(x+1, map.get(x), right) + going(left, map.get(x));
		int goRight = dfs(x+1, left, map.get(x)) + going(right, map.get(x));
		
		return dp[x][left][right] = Math.min(goLeft, goRight);
	}
	
	static int going(int go, int to) {
		if (go==0) return 2;
		if (Math.abs(go-to) == 2) return 4;
		if (go == to) return 1;
		return 3;
	}

}
