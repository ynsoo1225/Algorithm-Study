import java.util.*;
import java.io.*;

public class P2458_키순서_Main {
	
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] arr = new boolean[N+1][N+1];
		
		boolean[][] reverse_arr = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
			reverse_arr[b][a] = true;
		}
		
		//플로이드 와샬
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if (arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}
				}
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if (reverse_arr[i][k] && reverse_arr[k][j]) {
						reverse_arr[i][j] = true;
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] |= reverse_arr[i][j];
			}
		}
		
		int ans = 0;
		outer: for(int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if(i==j) {
					continue;
				}
				
				if (!arr[i][j]) {
					continue outer;
				}
			}
			ans++;
		}
		
		System.out.println(ans);

	}

}
