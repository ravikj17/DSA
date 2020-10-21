package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Number_Of_Paths_Between_Two_Vertices {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of vertices");
		int V = Integer.parseInt(br.readLine());
		System.out.println("Enter number of edges");
		int E = Integer.parseInt(br.readLine());
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		System.out.println("Enter edges");
		for (int i = 1; i <= E; i++) {
			String s[] = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			adj.get(u).add(v);
		}
		System.out.println("Enter source");
		int s = Integer.parseInt(br.readLine());
		System.out.println("Enter destination");
		int d = Integer.parseInt(br.readLine());
		int count = 0;
		count = path(s, d, adj);
		System.out.println("Number of possible paths between " + s + " and " + d + " is " + count);
	}

	static int path(int s, int d, List<List<Integer>> adj) {
		int c = 0;
		if (s == d)
			return 1;
		Iterator<Integer> itr = adj.get(s).listIterator();
		while (itr.hasNext()) {
			int n = (int) itr.next();
			c += path(n, d, adj);
		}
		return c;
	}

}
