package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Graph_Topological_sort {

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
		DFS_Check(adj);
	}

	static void DFS_Check(List<List<Integer>> adj) {
		Stack<Integer> st = new Stack<Integer>();
		int V = adj.size();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFS(adj, i, visited, st);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	static void DFS(List<List<Integer>> adj, int s, boolean visited[], Stack<Integer> stack) {
		int V = adj.size();
		visited[s] = true;
		Stack<Integer> st = new Stack<Integer>();
		st.push(s);
		while (!st.isEmpty()) {
			s = st.peek();
			Iterator<Integer> itr = adj.get(s).listIterator();
			boolean flag = true;
			while (itr.hasNext()) {
				int t = itr.next();
				if (!visited[t]) {
					flag = false;
					visited[t] = true;
					st.push(t);
					break;
				}
			}
			if (flag) {
				stack.push(st.pop());
			}
		}
	}

}
