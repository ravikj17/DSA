package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph_DFS_BFS {

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
		printGraph(adj, V, E);
		System.out.println("Enter source");
		int s = Integer.parseInt(br.readLine());
		System.out.println("Breadth First Treaversal of graph is");
		BFS(adj, s);
		System.out.println("DEPTH First Treaversal of graph is");
		DFS_Check(adj, s);
	}

	static void printGraph(List<List<Integer>> adj, int V, int E) {
		System.out.println("Graph is");
		for (int i = 0; i < V; i++) {
			if (!adj.get(i).isEmpty()) {
				System.out.print("Adjacent vertices of vertex " + i + " are -> ");
				for (int j = 0; j < adj.get(i).size(); j++) {
					System.out.print(adj.get(i).get(j) + "  ");
				}
				System.out.println();
			}
		}
	}

	static void BFS(List<List<Integer>> adj, int s) {
		int V = adj.size();
		boolean visited[] = new boolean[V];
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		while (!q.isEmpty()) {
			s = q.poll();
			System.out.print(s + " ");
			Iterator<Integer> itr = adj.get(s).listIterator();
			while (itr.hasNext()) {
				int u = itr.next();
				if (!visited[u]) {
					visited[u] = true;
					q.offer(u);
				}
			}
		}
		System.out.println();
	}

	static void DFS_Check(List<List<Integer>> adj, int s) {
		int V = adj.size();
		boolean visited[] = new boolean[V];
		for (int i = s; i < V; i++) {
			if (!visited[i]) {
				DFS(adj, i, visited);
			}
		}
		for (int i = 0; i < s; i++) {
			if (!visited[i]) {
				DFS(adj, i, visited);
			}
		}
	}

	static void DFS(List<List<Integer>> adj, int s, boolean visited[]) {
		int V = adj.size();
		visited[s] = true;
		Stack<Integer> st = new Stack<Integer>();
		System.out.print(s + " ");
		st.push(s);
		while (!st.isEmpty()) {
			s = st.peek();
			Iterator<Integer> itr = adj.get(s).listIterator();
			boolean flag = true;
			while (itr.hasNext()) {
				int t = itr.next();
				if (!visited[t]) {
					System.out.print(t + " ");
					flag = false;
					visited[t] = true;
					st.push(t);
					break;
				}
			}
			if (flag) {
				st.pop();
			}
		}
	}

}
