import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 0; tc < T; tc++) {
			char[] s = fs.next().toCharArray();
			char[] t = fs.next().toCharArray();
			if (t.length < s.length) {
				out.println("NO");
				continue;
			}
			boolean checker = true;
			int i = 0;
			int otherIndex = 0;
			boolean[] visited = new boolean[t.length];
			Arrays.fill(visited, false);
			while (i < s.length) {
				int curIndex = i;
				while (i < s.length && s[curIndex] == s[i]) {
					i++;
				}
				int freq = i - curIndex;
				if (otherIndex < t.length && t[otherIndex] != s[curIndex]) {
					checker = false;
					break;
				}
				int holdOther = otherIndex;
				while (otherIndex < t.length && t[otherIndex] == s[curIndex]) {
					visited[otherIndex] = true;
					otherIndex++;
				}
				int otherFreq = otherIndex - holdOther;
				if (otherFreq < freq) {
					checker = false;
					break;
				}
			}
			for (boolean vis : visited) {
				if (!vis) {
					checker = false;
					break;
				}
			}
			out.println(checker ? "YES" : "NO");
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
