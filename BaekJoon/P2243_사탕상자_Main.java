import java.util.Scanner;

public class P2243_ªÁ≈¡ªÛ¿⁄_Main {
	
	static Scanner sc = new Scanner(System.in);
	final static int INF = 1000001;
	
	static int n;
	static long[] arr;
	static long[] tree;
	
	static long make_tree(int node, int left, int right) {
		if (left==right) {
			return tree[node] = arr[left];
		}
		
		int mid = (left+right)/2;
		
		return make_tree(node*2, left, mid) + make_tree(node*2+1, mid+1, right);
	}
	
	static long upload_tree(int node, int id, int left, int right) {
		if (left==right) {
			return tree[node] = arr[id];
		}
		
		int mid = (left+right)/2;
		
		if (id <= mid) {
			return tree[node] = upload_tree(node*2, id, left, mid) + tree[node*2+1];
		}else {
			return tree[node] = upload_tree(node*2+1, id, mid+1, right) + tree[node*2];
		}
	}
	
	static int find_seq_cnd(int node, long seq, int left, int right) {
		if (left==right) {
			return left;
		}
		
		int mid = (left+right) / 2;
		
		if(tree[node*2] >= seq) {
			return find_seq_cnd(node*2, seq, left, mid);
		}else {
			return find_seq_cnd(node*2+1, seq-tree[node*2], mid+1, right);
		}
	}
	
	static void Solution() {
		n = sc.nextInt();
		arr = new long[INF];
		tree = new long[INF*4];
		
		make_tree(1, 1, INF-1);
		
		int a, b, c;
		int k;
		
		for(int i=0; i<n; i++) {
			a = sc.nextInt();
			if (a==1) {
				b = sc.nextInt();
				k = find_seq_cnd(1,b,1,INF-1);
				arr[k] -= 1;
				System.out.println(k);
				upload_tree(1,k,1,INF-1);
			}else {
				b = sc.nextInt();
				c = sc.nextInt();
				arr[b] += c;
				upload_tree(1,b,1,INF-1);
			}
		}
	}

	public static void main(String[] args) {
		
		Solution();

	}

}
