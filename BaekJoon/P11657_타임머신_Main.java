import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Bus {
	int start, end, weight;
	
	public Bus(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class P11657_타임머신_Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int M;
	static long dist[];
	static Bus busArr[];
	private static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		busArr = new Bus[M];
		dist = new long[N+1];
		
		for(int i=1; i<= N; i++) {
			dist[i] = INF;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			busArr[i] = new Bus(start, end, time);
		}
		
		dist[1] = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M; j++) {
				if(dist[busArr[j].start] == INF) {
					continue;
				}
				if(dist[busArr[j].end] > (dist[busArr[j].start] + busArr[j].weight)) {
					dist[busArr[j].end] = dist[busArr[j].start] + busArr[j].weight;
				}
			}
		}
		
		boolean check = false;
		
		for(int i=0; i<M; i++) {
			if(dist[busArr[i].start] != INF && dist[busArr[i].end] > (dist[busArr[i].start] + busArr[i].weight)) {
				check = true;
				break;
			}
		}
		
		
		if(check) {
			System.out.println("-1");
		}else {
			for(int i=2; i<=N; i++) {
				if(dist[i]==INF) {
					System.out.println("-1");
				}else {
					System.out.println(dist[i]);
				}
			}
		}
		
	}

}
