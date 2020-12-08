package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Detect_Cycle_Directed_Graph {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of vertices");
		int V = Integer.parseInt(br.readLine());
		System.out.println("Enter number of edges");
		int E = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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
		System.out.println(isCyclic(adj, V));
	}

	static boolean[] wSet;
	static boolean[] bSet;

	static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
		for (int i = 0; i < V; i++) {
			boolean[] visited = new boolean[V];
			if (DFS(adj, i, visited)) {
				return true;
			}
		}
		return false;
	}

	static boolean DFS(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited) {

		visited[v] = true;
		Iterator<Integer> itr = adj.get(v).listIterator();
		while (itr.hasNext()) {
			int n = itr.next();
			if (visited[n])
				return true;
			visited[n] = true;
			if (DFS(adj, n, visited))
				return true;
			visited[n] = false;
		}
		return false;

	}

}
