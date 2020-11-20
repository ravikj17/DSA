package BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Search_Tree_Impl {

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

	static void inOrder_Recursive(TreeNode root) {
		if (root == null)
			return;
		inOrder_Recursive(root.left);
		System.out.print(root.data + " ");
		inOrder_Recursive(root.right);
	}

	static void preOrder_Recursive(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder_Recursive(root.left);
		preOrder_Recursive(root.right);
	}

	static void postOrder_Recursive(TreeNode root) {
		if (root == null)
			return;
		postOrder_Recursive(root.left);
		postOrder_Recursive(root.right);
		System.out.print(root.data + " ");
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
		System.out.println("Inorder traversal:");
		inOrder_Recursive(root);
		System.out.println();
		System.out.println("Preorder traversal:");
		preOrder_Recursive(root);
		System.out.println();
		System.out.println("Postorder traversal:");
		postOrder_Recursive(root);
		System.out.println();
		System.out.println("Level order traversal:");
		level_Order(root);
	}

}
