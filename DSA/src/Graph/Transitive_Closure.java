package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transitive_Closure {

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
		int closure[][] = new int[V][V];
		int i = 0;
		while (i < V) {
			closure[i][i] = 1;
			i++;
		}
		findClosure(adj, closure);
		System.out.println("Transitive closure is : ");
		for (i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(closure[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void findClosure(List<List<Integer>> adj, int[][] closure) {
		int V = adj.size();
		for (int i = 0; i < V; i++) {
			boolean check[] = new boolean[adj.size()];
			DFS(adj, i, check);
			for (int j = 0; j < V; j++) {
				if (check[j])
					closure[i][j] = 1;
			}
		}
	}

	static void DFS(List<List<Integer>> adj, int s, boolean[] check) {
		check[s] = true;
		Iterator<Integer> itr = adj.get(s).listIterator();
		while (itr.hasNext()) {
			int n = (int) itr.next();
			if (!check[n]) {
				DFS(adj, n, check);
			}
		}
	}

}
