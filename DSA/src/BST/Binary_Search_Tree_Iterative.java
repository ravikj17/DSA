package BST;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Binary_Search_Tree_Iterative {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

		TreeNode(int data) {
			this.data = data;
		}
	}

	static TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			TreeNode p = new TreeNode(data);
			root = p;
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		}
		return root;
	}

	static List<Integer> preOrder_Iterative(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode curr = st.pop();
			l.add(curr.data);
			if (curr.right != null)
				st.push(curr.right);
			if (curr.left != null)
				st.push(curr.left);
		}
		return l;
	}

	static List<Integer> inOrder_Iterative(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !st.isEmpty()) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			curr = st.pop();
			l.add(curr.data);
			curr = curr.right;
		}
		return l;
	}

	static List<Integer> postOrder_Iterative(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		st1.push(root);
		while (!st1.isEmpty()) {
			TreeNode p = st1.pop();
			st2.push(p);
			if (p.left != null)
				st1.push(p.left);
			if (p.right != null)
				st1.push(p.right);
		}
		while (!st2.isEmpty()) {
			l.add(st2.pop().data);
		}
		return l;
	}

	static void level_Order(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode q = queue.poll();
			System.out.print(q.data + " ");
			if (q.left != null)
				queue.add(q.left);
			if (q.right != null)
				queue.add(q.right);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter elements");
		String st[] = br.readLine().split(" ");
		TreeNode root = null;
		for (int i = 0; i < st.length; i++) {
			int data = Integer.parseInt(st[i]);
			root = insert(root, data);
		}
		// 50 30 20 40 70 60 80
		System.out.println("InOrder traversal:");
		List<Integer> list1 = inOrder_Iterative(root);
		System.out.println(list1);
		System.out.println("PreOrder traversal:");
		List<Integer> list2 = preOrder_Iterative(root);
		System.out.println(list2);
		System.out.println("PostOrder traversal:");
		List<Integer> list3 = postOrder_Iterative(root);
		System.out.println(list3);

	}

}
