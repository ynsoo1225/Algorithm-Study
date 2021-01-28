import java.io.*;
import java.util.*;

public class P3020_°³¶Ë¹ú·¹_Main {
	
	static int N;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] floor = new int[N/2];
		int[] ceiling = new int[N/2];
		int[] cntArr = new int[M];
		int min = Integer.MAX_VALUE;
		int minCnt = 0;
		
		for(int i=0; i<N; i++) {
			int l = Integer.parseInt(br.readLine());
			if(i%2==0) {
				floor[i/2] = l;
			}else {
				ceiling[i/2] = l;
			}
		}
		
		Arrays.sort(floor);
		Arrays.sort(ceiling);
		
		for(int i=1; i<=M; i++) {
			int j = binarySearch(0, N/2-1, i, floor);
			int k = binarySearch(0, N/2-1, M-i+1, ceiling);
			cntArr[i-1] = j+k;
			if(min>cntArr[i-1]) {
				min = cntArr[i-1];
			}
		}
		
		for(int i=0; i<M; i++) {
			if(min==cntArr[i]) {
				minCnt++;
			}
		}
		
		System.out.println(min+" "+minCnt);

	}
	
	static int binarySearch(int above, int below, int h, int[] arr) {
		int left = above;
		int right = below;
		
		int min = Integer.MAX_VALUE;
		
		while (left<=right) {
			int mid = (left + right) /2;
			
			if(h<=arr[mid]) {
				min = Math.min(min, mid);
				right = mid -1;
			}else {
				left = mid + 1;
			}
		}
		
		if(min==Integer.MAX_VALUE) {
			return 0;
		}
		
		return N/2-min;
	}

}
