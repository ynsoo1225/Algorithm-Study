import java.util.*;
import java.io.*;

public class P7578_����_Main {
	
	static int N;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] A = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> B = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int val = Integer.parseInt(st.nextToken());
			B.put(val, i);
		}
		
		tree = new long[N*4];
		long ans = 0;
		
		for(int i=1; i<=N; i++) {
			int valA = A[i];
			int valB = B.get(valA); //A[i]�� ���� �ĺ���ȣ�� �ִ� �ε��� ã��
			
			//valB���� ū �ε��� �� �̹� �湮�� �� �ִ� �ε����� ���� ���ϱ�
			ans += sum(1, N, 1, valB+1, N);
			
			//valB �湮�ߴٴ� �ǹ̷� 1 �����ֱ�
			//���ÿ� valB�� ���Ե� �������� ��� 1�� ������
			update(1, N, 1, valB, 1);
		}
		
		System.out.println(ans);

	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		if(end<left || right<start) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	public static void update(int start, int end, int node, int idx, int dif) {
		if(idx<start || idx > end) {
			return;
		}
		
		tree[node] += dif;
		
		if(start != end) {
			int mid = (start+end) / 2;
			update(start, mid, node*2, idx, dif);
			update(mid+1, end, node*2+1, idx, dif);
		}
	}

}
