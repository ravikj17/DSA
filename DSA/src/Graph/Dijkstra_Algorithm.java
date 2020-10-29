package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dijkstra_Algorithm {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of vertices");
		int V = Integer.parseInt(br.readLine());
		int[][] graph = new int[V][V];
		System.out.println("Enter edges");
		for (int i = 0; i < V; i++) {
			String st[] = br.readLine().split(" ");
			for (int j = 0; j < V; j++) {
				graph[i][j] = Integer.parseInt(st[j]);
			}
		}
		System.out.println("Enter source vertex");
		int s = Integer.parseInt(br.readLine());
		dijkstra(graph, s);

	}

	static void dijkstra(int[][] graph, int src) {

		int V = graph.length;
		int distance[] = new int[V];
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src] = 0;
		for (int i = 0; i < V - 1; i++) {
			int u = minDist(distance, visited);
			visited[u] = true;
			for (int v = 0; v < V; v++) {
				if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
						&& distance[u] + graph[u][v] < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}
		System.out.println("Vertex\t\tDistance from source " + src);
		for (int i = 0; i < visited.length; i++) {
			System.out.println(i + "\t\t" + distance[i]);
		}

	}

	static int minDist(int[] distance, boolean[] visited) {
		int V = visited.length;
		int min = Integer.MAX_VALUE;
		int min_idx = -1;
		for (int i = 0; i < V; i++) {
			if (!visited[i] && min >= distance[i]) {
				min = distance[i];
				min_idx = i;
			}
		}
		return min_idx;
	}

}
