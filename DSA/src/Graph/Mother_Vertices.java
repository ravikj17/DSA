package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * What is a Mother Vertex? 
A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G can be reached by a path from v.
 */

public class Mother_Vertices {

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
		boolean[] visited = new boolean[V];
		int m = find_Mother_Vertex(adj, visited);
		System.out.println("Mother vertex is " + m);
		List<Integer> moV = new ArrayList<Integer>();
		find_Mother_Vertices(adj, moV);
		System.out.println("All mother vertices are " + moV);

	}

	static int find_Mother_Vertex(List<List<Integer>> adj, boolean[] visited) {
		int v = -1;
		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i]) {
				DFS(adj, i, visited);
				v = i;
			}
		}

		boolean check[] = new boolean[adj.size()];
		DFS(adj, v, check);
		for (boolean i : check) {
			if (!i)
				return -1;
		}
		return v;
	}

	static void find_Mother_Vertices(List<List<Integer>> adj, List<Integer> moV) {
		for (int i = 0; i < adj.size(); i++) {
			boolean check[] = new boolean[adj.size()];
			DFS(adj, i, check);
			boolean flag = true;
			for (boolean c : check) {
				if (!c) {
					flag = false;
					break;
				}
			}
			if (flag)
				moV.add(i);
		}
	}

	static void DFS(List<List<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		Iterator<Integer> itr = adj.get(s).listIterator();
		while (itr.hasNext()) {
			int n = (int) itr.next();
			if (!visited[n]) {
				DFS(adj, n, visited);
			}
		}

	}

}
